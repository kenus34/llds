package org.llds.zoom;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        UserService userService = new UserService();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10000;++i){
                    userService.add(User.builder()
                                    .name(Thread.currentThread().getName()+"-"+i)
                                    .number(9089743348L)
                                    .status(UserStatus.ACTIVE)
                            .build());
                }
            }
        };
        Thread t1 = new Thread(runnable);
        t1.setName("t1");
        Thread t2 = new Thread(runnable);
        t2.setName("t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(userService.size());
        userService.listDisc();
    }
}
