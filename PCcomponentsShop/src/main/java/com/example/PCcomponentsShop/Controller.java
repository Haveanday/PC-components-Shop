package com.example.PCcomponentsShop;

import Exceptions.EntityAlreadyExistsException;
import Exceptions.EntityNotFoundException;
import Model.*;
import Repository.ComponentsRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.logging.Logger;
import java.util.stream.Stream;

@RestController
public class Controller {
    private static final Logger logger = Logger.getLogger(String.valueOf(Controller.class.getName()));

    LinkedList<ComponentsRepository> list = new LinkedList<ComponentsRepository>();
    ComponentsRepository componentsRepository = new ComponentsRepository();
    Stream<ComponentsRepository> stream = list.stream();

    LinkedList<GraphicsCard> graphicsCardLinkedList = new LinkedList<GraphicsCard>();

    public void averagePrice() {
        AveragePrice averagePrice = graphicsCardLinkedList.stream()
                .filter(p -> p.getRating() == Rating.HIGH)
                .map(GraphicsCard::getPrice)
                .collect(AveragePrice::new, AveragePrice::accept, AveragePrice::combine);

        System.out.println("Average price of high rating graphics cards (without special offers included): " +
                averagePrice.average());
    }

    public void countNotForSale() {
        long counter = stream
                .map((value) -> { return value.getGraphicsCardHashMap();})
                .count();
        System.out.println("Graphics cards (without special offers included) amount = " + counter);
    }


    @GetMapping("/pc-components")
    public synchronized ResponseEntity<Object> allItems() throws EntityNotFoundException {
        if (componentsRepository.isComponentsRepositoryEmpty())
            throw new EntityNotFoundException();
        else
            return new ResponseEntity<>(componentsRepository.getCpuHashMap().toString() +
                    componentsRepository.getGraphicsCardHashMap().toString() +
                    componentsRepository.getSsdHashMap().toString(), HttpStatus.OK);

    }

    @GetMapping("/cpu-s")
        public synchronized ResponseEntity<Object> allCPUs() throws EntityNotFoundException {
            if (componentsRepository.isCPUHashMapEmpty())
                throw new EntityNotFoundException();
            else
                return new ResponseEntity<>(componentsRepository.getCpuHashMap().toString(), HttpStatus.OK);
    }

    @GetMapping("/graphics-cards")
    public synchronized ResponseEntity<Object> allGraphicCards() throws EntityNotFoundException {
        countNotForSale();
        averagePrice();
        if (componentsRepository.isGraphicsCardHashMapEmpty())
            throw new EntityNotFoundException();
        else
            return new ResponseEntity<>(componentsRepository.getGraphicsCardHashMap().toString(), HttpStatus.OK);
    }

    @GetMapping("/SSD-s")
    public synchronized ResponseEntity<Object> allSSDs() throws EntityNotFoundException {
        if (componentsRepository.isSSDHashMapEmpty())
            throw new EntityNotFoundException();
        else
            return new ResponseEntity<>(componentsRepository.getSsdHashMap().toString(), HttpStatus.OK);
    }

        @PostMapping("/cpu-s/add/{id}/{name}/{price}/{coreName}/{socketType}/{coreNumber}/{threadsNumber}/{frequency}/{releaseDate}")
            public synchronized ResponseEntity<Object> addCpu(@PathVariable Integer id,
                                                  @PathVariable String name,
                                                  @PathVariable double price,
                                                  @PathVariable String coreName,
                                                  @PathVariable String socketType,
                                                  @PathVariable int coreNumber,
                                                  @PathVariable int threadsNumber,
                                                  @PathVariable double frequency,
                                                  @PathVariable int releaseDate) throws EntityAlreadyExistsException {
            if (!componentsRepository.containsCPUItem(id)) {
                    CPU cpuItem = new CPU(name,
                            price,
                            coreName,
                            socketType,
                            coreNumber,
                            threadsNumber,
                            frequency,
                            releaseDate);
                    componentsRepository.addCPUItem(id, cpuItem);
                logger.info("The item was added.");
               return new ResponseEntity<>("The item was added.", HttpStatus.OK);
            }
            throw new EntityAlreadyExistsException();
        }

    @PostMapping("/graphics-cards/add/{id}/{name}/{price}/{coreClock}/{memorySize}/{cardInterface}/{rating}")
    public synchronized ResponseEntity<Object> addGraphicsCard(@PathVariable Integer id,
                                                  @PathVariable String name,
                                                  @PathVariable double price,
                                                  @PathVariable int coreClock,
                                                  @PathVariable int memorySize,
                                                  @PathVariable String cardInterface,
                                                               @PathVariable Rating rating) throws EntityAlreadyExistsException {
        if(!componentsRepository.containsGraphicsCardItem(id)) {
                GraphicsCard graphicsCardItem = new GraphicsCard(name,
                        price,
                        coreClock,
                        memorySize,
                        cardInterface,
                        rating);
                componentsRepository.addGraphicsCardItem(id, graphicsCardItem);
            list.add(componentsRepository);
            graphicsCardLinkedList.add(graphicsCardItem);
            logger.info("The item was added.");
            return new ResponseEntity<>("The item was added.", HttpStatus.OK);
        }
        throw new EntityAlreadyExistsException();
    }

    @PostMapping("/SSDs/add/{id}/{name}/{price}/{SSDInterface}/{capacity}/{maxSequentialRead}/{maxSequentialWrite}/{formFactor}")
    public synchronized ResponseEntity<Object> addSSD(@PathVariable Integer id,
                                         @PathVariable String name,
                                         @PathVariable double price,
                                         @PathVariable String SSDInterface,
                                         @PathVariable int capacity,
                                         @PathVariable String maxSequentialRead,
                                         @PathVariable String maxSequentialWrite,
                                         @PathVariable String formFactor) {
        if(!componentsRepository.containsSSDItem(id)) {
            SSD ssdItem = new SSD(name,
                    price,
                    SSDInterface,
                    capacity,
                    maxSequentialRead,
                    maxSequentialWrite,
                    formFactor);
            componentsRepository.addSSDItem(id, ssdItem);
            logger.info("The item was added.");
            return new ResponseEntity<>("The item was added.", HttpStatus.OK);
        }
        throw new EntityAlreadyExistsException();
    }

    @PutMapping("/cpu-s/update/{id}/{name}/{price}/{coreName}/{socketType}/{coreNumber}/{threadsNumber}/{frequency}/{releaseDate}")
    public synchronized ResponseEntity<Object> updateCPUList(@PathVariable Integer id,
                                                @PathVariable String name,
                                                @PathVariable double price,
                                                @PathVariable String coreName,
                                                @PathVariable String socketType,
                                                @PathVariable int coreNumber,
                                                @PathVariable int threadsNumber,
                                                @PathVariable double frequency,
                                                @PathVariable int releaseDate) {
        if(componentsRepository.containsCPUItem(id)) {
            componentsRepository.replaceCPUItem(id, new CPU(name,
                    price,
                    coreName,
                    socketType,
                    coreNumber,
                    threadsNumber,
                    frequency,
                    releaseDate));
            logger.info("The item was updated.");
            return new ResponseEntity<>("The item was updated.", HttpStatus.OK);
        }
        throw new EntityNotFoundException();
    }

    @PutMapping("/graphics-cards/update/{id}/{name}/{price}/{coreClock}/{memorySize}/{cardInterface}/{rating}")
    public synchronized ResponseEntity<Object> updateGraphicsCardsList(@PathVariable Integer id,
                                                          @PathVariable String name,
                                                          @PathVariable double price,
                                                          @PathVariable int coreClock,
                                                          @PathVariable int memorySize,
                                                          @PathVariable String cardInterface,
                                                                       @PathVariable Rating rating) {
        if(componentsRepository.containsGraphicsCardItem(id)) {
            componentsRepository.replaceGraphicsCardItem(id, new GraphicsCard(name,
                    price,
                    coreClock,
                    memorySize,
                    cardInterface,
                    rating));
            logger.info("The item was updated.");
            return new ResponseEntity<>("The item was updated.", HttpStatus.OK);
        }
        throw new EntityNotFoundException();
    }

    @PutMapping("/SSDs/update/{id}/{name}/{price}/{SSDInterface}/{capacity}/{maxSequentialRead}/{maxSequentialWrite}/{formFactor}")
    public synchronized ResponseEntity<Object> updateSSDList(@PathVariable Integer id,
                                                          @PathVariable String name,
                                                          @PathVariable double price,
                                                          @PathVariable String SSDInterface,
                                                          @PathVariable int capacity,
                                                          @PathVariable String maxSequentialRead,
                                                          @PathVariable String maxSequentialWrite,
                                                          @PathVariable String formFactor) {
        if(componentsRepository.containsSSDItem(id)) {
            componentsRepository.replaceSSDItem(id, new SSD(name,
                    price,
                    SSDInterface,
                    capacity,
                    maxSequentialRead,
                    maxSequentialWrite,
                    formFactor));
            logger.info("The item was updated.");
            return new ResponseEntity<>("The item was updated.", HttpStatus.OK);
        }
        throw new EntityNotFoundException();
    }


    @DeleteMapping("/cpu-s/delete/{id}")
    public synchronized ResponseEntity<Object> deleteCPU(@PathVariable Integer id) {
        if(componentsRepository.containsCPUItem(id)) {
            componentsRepository.deleteCPUItem(id);
            logger.info("The item was successfully deleted.");
            return new ResponseEntity<>("The item was successfully deleted.", HttpStatus.OK);
        }
            throw new EntityNotFoundException();
    }

    @DeleteMapping("/graphics-cards/delete/{id}")
    public synchronized ResponseEntity<Object> deleteGraphicsCard(@PathVariable Integer id) {
        if(componentsRepository.containsGraphicsCardItem(id)) {
            componentsRepository.deleteGraphicsCardItem(id);
            logger.info("The item was successfully deleted.");
            return new ResponseEntity<>("The item was successfully deleted.", HttpStatus.OK);
        }
            throw new EntityNotFoundException();
    }

    @DeleteMapping("/SSDs/delete/{id}")
    public synchronized ResponseEntity<Object> deleteSSD(@PathVariable Integer id) {
        if(componentsRepository.containsSSDItem(id)) {
            componentsRepository.deleteSSDItem(id);
            logger.info("The item was successfully deleted.");
            return new ResponseEntity<>("The item was successfully deleted.", HttpStatus.OK);
        }
            throw new EntityNotFoundException();
    }
}
