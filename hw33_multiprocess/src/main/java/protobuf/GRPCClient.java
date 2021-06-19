package protobuf;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import protobuf.generated.Empty;
import protobuf.generated.RemoteDBServiceGrpc;
import protobuf.generated.UserMessage;

import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

public class GRPCClient {

    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8190;

    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(SERVER_HOST, SERVER_PORT)
                .usePlaintext()
                .build();

        RemoteDBServiceGrpc.RemoteDBServiceBlockingStub stub = RemoteDBServiceGrpc.newBlockingStub(channel);
        UserMessage savedUserMsg = stub.saveUser(
                UserMessage.newBuilder().setFirstName("Вася").setLastName("Кириешкин").build()
        );

        System.out.println(String.format("Мы сохранили Васю: {id: %d, name: %s %s}",
                savedUserMsg.getId(), savedUserMsg.getFirstName(), savedUserMsg.getLastName()));

        Iterator<UserMessage> allUsersIterator = stub.findAllUsers(Empty.getDefaultInstance());
        System.out.println("Конградулейшенз! Мы получили юзеров! Среди них должен найтись один Вася!");
        allUsersIterator.forEachRemaining(um ->
                System.out.println(String.format("{id: %d, name: %s %s}",
                        um.getId(), um.getFirstName(), um.getLastName()))
        );

        CountDownLatch latch = new CountDownLatch(1);
        System.out.println("\n\n\nА теперь тоже самое, только асинхронно!!!\n\n");
        RemoteDBServiceGrpc.RemoteDBServiceStub newStub = RemoteDBServiceGrpc.newStub(channel);
        newStub.findAllUsers(Empty.getDefaultInstance(), new StreamObserver<UserMessage>() {
            @Override
            public void onNext(UserMessage um) {
                System.out.println(String.format("{id: %d, name: %s %s}",
                        um.getId(), um.getFirstName(), um.getLastName()));
            }

            @Override
            public void onError(Throwable t) {
                System.err.println(t);
            }

            @Override
            public void onCompleted() {
                System.out.println("\n\nЯ все!");
                latch.countDown();
            }
        });

        latch.await();

        channel.shutdown();
    }
}