package Repository;

import Model.CPU;
import Model.GraphicsCard;
import Model.SSD;

import java.util.HashMap;

public class ComponentsRepository {
    Integer id;
    public static HashMap<Integer, CPU> cpuHashMap = new HashMap<Integer, CPU>();
    public static HashMap<Integer, GraphicsCard> graphicsCardHashMap = new HashMap<Integer, GraphicsCard>();
    public static HashMap<Integer, SSD> ssdHashMap = new HashMap<Integer, SSD>();

    public ComponentsRepository() {
       cpuHashMap = new HashMap<Integer, CPU>();
       graphicsCardHashMap = new HashMap<Integer, GraphicsCard>();
       ssdHashMap = new HashMap<Integer, SSD>();
    }

//----get----//
    public HashMap<Integer, CPU> getCpuHashMap() {
        return cpuHashMap;
    }

    public HashMap<Integer, GraphicsCard> getGraphicsCardHashMap() {
        return graphicsCardHashMap;
    }

    public HashMap<Integer, SSD> getSsdHashMap() {
        return ssdHashMap;
    }
//----get----//

//----add----//
    public void addCPUItem(Integer id, CPU item) {
        cpuHashMap.put(id, item);
    }

    public HashMap<Integer, GraphicsCard> addGraphicsCardItem(Integer id, GraphicsCard item) {
        graphicsCardHashMap.put(id, item);
        return graphicsCardHashMap;
    }

    public void addSSDItem(Integer id, SSD item) {
        ssdHashMap.put(id, item);
    }
//----add----//

//----delete---//
    public void deleteCPUItem(Integer id) {
        cpuHashMap.remove(id);
    }

    public HashMap<Integer, GraphicsCard> deleteGraphicsCardItem(Integer id) {
        graphicsCardHashMap.remove(id);
        return graphicsCardHashMap;
    }

    public void deleteSSDItem(Integer id) {
        ssdHashMap.remove(id);
    }
//----delete---//

//----replace----//
    public void replaceCPUItem(Integer id, CPU item) {
        cpuHashMap.put(id, item);
    }

    public HashMap<Integer, GraphicsCard> replaceGraphicsCardItem(Integer id, GraphicsCard item) {
        graphicsCardHashMap.put(id, item);
        return graphicsCardHashMap;
    }

    public void replaceSSDItem(Integer id, SSD item) {
        ssdHashMap.put(id, item);
    }
//----replace----//

//----contains----//
    public boolean containsCPUItem(Integer id) {
        return cpuHashMap.containsKey(id);
    }

    public boolean containsGraphicsCardItem(Integer id) {
        return graphicsCardHashMap.containsKey(id);
    }

    public boolean containsSSDItem(Integer id) {
        return ssdHashMap.containsKey(id);
    }
//----contains----//

//----is empty----//
    public boolean isComponentsRepositoryEmpty() {
        if (cpuHashMap.isEmpty() && graphicsCardHashMap.isEmpty() && ssdHashMap.isEmpty())
            return true;
        else
            return false;
    }

    public boolean isCPUHashMapEmpty() {
        return cpuHashMap.isEmpty();
    }

    public boolean isGraphicsCardHashMapEmpty() {
        return graphicsCardHashMap.isEmpty();
    }

    public boolean isSSDHashMapEmpty() {
        return ssdHashMap.isEmpty();
    }

//----is empty----//

}
