package springbootjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springbootjdbc.crm.model.ClientBD;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) throws InterruptedException {

 //       List<ClientBD> clientBDList = new ArrayList<>();
 //       ClientBD clientBDSaved = new ClientBD();

        var context = SpringApplication.run(Main.class, args);

        context.getBean("initBD", InitBD.class).action();

  /*      CountDownLatch latch = new CountDownLatch(2);

        context.getBean("frontendServiceBD", FrontendServiceBD.class ).
                saveClientBD(new ClientBD("a","b","c"),
                        data -> {
                    logger.info("got data clientBD saved:{}", data);
                    clientBDSaved.copyFrom(data);
                            latch.countDown();
                        });

        context.getBean("frontendServiceBD", FrontendServiceBD.class ).
                                  getClientBDList(
                                          data -> {
                                              if (data.getId() > 0) {
                                                  clientBDList.add(data);
                                              } else {
                                                  logger.info("got data  for list clientBD:{}", clientBDList);
                                                  latch.countDown();
                                              }
                                          }
                                              );
        latch.await();
        System.out.println(clientBDSaved);
       System.out.println(clientBDList);


*/
      /*  Thread.sleep(100);
        ((MessageSystem) context.getBean("messageSystem")).dispose();
        logger.info("done");

       */
    }
}
