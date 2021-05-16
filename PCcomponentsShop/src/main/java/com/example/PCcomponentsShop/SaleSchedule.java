package com.example.PCcomponentsShop;

import Model.GraphicsCard;
import Model.Rating;
import Repository.ComponentsRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@EnableAsync
public class SaleSchedule {

    private ComponentsRepository componentsRepository = new ComponentsRepository();

    Logger logger = Logger.getLogger(String.valueOf(SaleSchedule.class));

    @Async
    @Scheduled(cron = "0 0 0 10 * ?") //graphics cards sales starts on the 10th day of every month
    public synchronized void startSales() {
        GraphicsCard graphicsCard = new GraphicsCard("SPECIAL ORDER:\n"+ "Palit GeForce GTX1660", 299.90, 1530, 4, "PCI Express X16 3.0", Rating.HIGH);
        componentsRepository.addGraphicsCardItem(777, graphicsCard);
        logger.info("Sales started.");
    }
}
