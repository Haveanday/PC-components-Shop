package com.example.PCcomponentsShop;

import Exceptions.EntityAlreadyExistsException;
import Exceptions.EntityNotFoundException;
import Model.*;
import Repository.ComponentsRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
public class Controller {
    private static final Logger logger = Logger.getLogger(String.valueOf(Controller.class.getName()));

    ComponentsRepository componentsRepository = new ComponentsRepository();


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

    @PostMapping("/graphics-cards/add/{id}/{name}/{price}/{coreClock}/{memorySize}/{cardInterface}")
    public synchronized ResponseEntity<Object> addGraphicsCard(@PathVariable Integer id,
                                                  @PathVariable String name,
                                                  @PathVariable double price,
                                                  @PathVariable int coreClock,
                                                  @PathVariable int memorySize,
                                                  @PathVariable String cardInterface) throws EntityAlreadyExistsException {
        if(!componentsRepository.containsGraphicsCardItem(id)) {
                GraphicsCard graphicsCardItem = new GraphicsCard(name,
                        price,
                        coreClock,
                        memorySize,
                        cardInterface);
                componentsRepository.addGraphicsCardItem(id, graphicsCardItem);
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

    @PutMapping("/graphics-cards/update/{id}/{name}/{price}/{coreClock}/{memorySize}/{cardInterface}")
    public synchronized ResponseEntity<Object> updateGraphicsCardsList(@PathVariable Integer id,
                                                          @PathVariable String name,
                                                          @PathVariable double price,
                                                          @PathVariable int coreClock,
                                                          @PathVariable int memorySize,
                                                          @PathVariable String cardInterface) {
        if(componentsRepository.containsGraphicsCardItem(id)) {
            componentsRepository.replaceGraphicsCardItem(id, new GraphicsCard(name,
                    price,
                    coreClock,
                    memorySize,
                    cardInterface));
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
