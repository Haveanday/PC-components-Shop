package com.example.PCcomponentsShop;

import Model.CPU;
import Model.GraphicsCard;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class Controller {
    public HashMap<Integer, CPU> cpuHashMap = new HashMap<Integer, CPU>();
    public HashMap<Integer, GraphicsCard> graphicsCardHashMap = new HashMap<Integer, GraphicsCard>();

    @GetMapping("/pc-components")
        public String allItems() {
        return cpuHashMap.toString() + graphicsCardHashMap.toString();
        }

        @PostMapping("/cpu-s/add")
            public String addCpu() {
            cpuHashMap.put(1239700, new CPU(
                    "Intel Core i7-9700k",
                    1021.97,
                    "Coffee Lake",
                    "LGA1151 V2",
                    8,
                    0,
                    3.6,
                    0));
            cpuHashMap.put(1238700, new CPU(
                    "Intel Core i7-8700k",
                    1091.58,
                    "Coffee Lake",
                    "LGA1151 V2",
                    6,
                    0,
                    3.7,
                    0));
            return "All devices were added successfully.";
        }

    @PostMapping("/graphics-cards/add")
    public String addGraphicsCard() {
            graphicsCardHashMap.put(1241660, new GraphicsCard(
                    "Gigabyte GeForce GTX1660",
                    567.32,
                    1485,
                    6,
                    "PCI Express X16 3.0"));
            graphicsCardHashMap.put(1241650, new GraphicsCard(
                    "Palit GeForce GTX1660",
                    381.18,
                    1530,
                    4,
                    "PCI Express X16 3.0"));
            return "All devices were added successfully.";
    }
    @PutMapping("/graphics-cards/update")
    public String updateGraphicsCardsList() {
        if(graphicsCardHashMap.containsKey(1241660)) {
            graphicsCardHashMap.replace(1241660, new GraphicsCard(
                    "Palit GeForce GTX1070 Dual",
                    1163.39,
                    1506,
                    8,
                    "PCI Express X16 3.0"));
            return "Item replaced successfully.";
        }
        else return "There is no item found.";
    }
    @DeleteMapping("/cpu-s/delete")
    public String deleteCpu() {
        if(!cpuHashMap.isEmpty()) {
            cpuHashMap.remove(1238700);
            return "Item deleted successfully.";
        } else
            return "There is no item found.";
    }
}