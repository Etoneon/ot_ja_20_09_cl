package protobuf.service;

import io.grpc.stub.StreamObserver;
import protobuf.generated.Empty;
import protobuf.generated.RemoteDBServiceGrpc;
import protobuf.generated.UserMessage;
import protobuf.model.User;

import java.util.List;

public class RemoteDBServiceImpl extends RemoteDBServiceGrpc.RemoteDBServiceImplBase {

    private final RealDBService realDBService;

    public RemoteDBServiceImpl(RealDBService realDBService) {
        this.realDBService = realDBService;
    }

    @Override
    public void saveUser(UserMessage request, StreamObserver<UserMessage> responseObserver) {
        User user = realDBService.saveUser(request.getFirstName(), request.getLastName());
        responseObserver.onNext(user2UserMessage(user));
        responseObserver.onCompleted();
    }

    @Override
    public void findAllUsers(Empty request, StreamObserver<UserMessage> responseObserver) {
        List<User> allUsers = realDBService.findAllUsers();
        allUsers.forEach(u -> responseObserver.onNext(user2UserMessage(u)));
        responseObserver.onCompleted();
    }

    private UserMessage user2UserMessage(User user) {
        return UserMessage.newBuilder()
                .setId(user.getId())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .build();
    }
}