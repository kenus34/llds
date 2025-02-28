package org.llds.zoom;

import org.junit.jupiter.api.Test;

import java.awt.print.Book;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

class BookingServiceTest {

    private Vehicle getVehicle(){
        return Vehicle.builder()
                .make("Honda")
                .model("City")
                .vehicleStatus(new AtomicReference<>(VehicleStatus.AVAILABLE))
                .storeId(0)
                .build();
    }
    volatile int  rc =0;
    @Test
    void createBooking() throws InterruptedException {
        VehicleService vehicleService = new VehicleService();
        Thread t1 = new Thread(() -> {
            for(int i=0;i<10000;++i){
                vehicleService.add(getVehicle());
            }
        });
        Thread t2 = new Thread(() -> {
            for(int i=0;i<10000;++i){
                vehicleService.add(getVehicle());
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        UserService userService = new UserService();
        userService.add(User.builder()
                        .name("Kent")
                        .status(UserStatus.ACTIVE)
                        .number(9089743348L)
                .build());
        BookingService bookingService = new BookingService(new PaymentService(), vehicleService, userService);

        vehicleService.listDisc();
        t1= new Thread(()->{
            for(int i=0;i<4000;++i){
                Vehicle vehicle = (Vehicle) vehicleService.entities.peek();
                try {
                    bookingService.createBooking(vehicle.getId(), 1, 2);
                    vehicleService.entities.poll();
                } catch (Exception e) {
                    ++rc;

                }
            }
        });
        t2= new Thread(()->{
            for(int i=0;i<4000;++i){
                Vehicle vehicle = (Vehicle) vehicleService.entities.peek();
                try {
                    bookingService.createBooking(vehicle.getId(), 1, 2);
                    vehicleService.entities.poll();
                } catch (Exception e) {
                    ++rc;

                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(rc);
        Set<Integer> s = new HashSet<>();
        for(Entity booking: bookingService.entities){
            Booking b = (Booking) booking;
            if(s.contains(b.getVehicleId())){
                System.out.println(b.getVehicleId());
            }else{
                s.add(b.getVehicleId());
            }
        }

    }
}