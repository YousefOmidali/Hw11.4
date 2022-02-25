package Repository;

import Entity.Master;
import Entity.MasterLevel;

public class MasterRepository {
    private Master[] master = new Master[1000];
    private Integer masterIndex = 0;

    public void signUpMaster(Master master) {
        this.master[masterIndex] = master;
        masterIndex++;
    }

    public void removeMaster(Integer index) {
        this.master[index] = master[masterIndex];
        masterIndex--;
    }

    public void editMaster(Integer index, Master master) {
        this.master[index].setFirstName(master.getFirstName());
        this.master[index].setLastName(master.getLastName());
        this.master[index].setUserName(master.getUserName());
        this.master[index].setPassword(master.getPassword());
        this.master[index].setMasterLevel(master.getMasterLevel());
        this.master[index].setTedadJalasatTadris(master.getTedadJalasatTadris());
    }
    public void masterInfo(Integer masterIndex) {
        System.out.println(master[masterIndex]);
    }
    public Integer paySlip(Integer masterIndex, Integer tedadTermeTadris) {
        Integer salary = 0;
        if (master[masterIndex].getMasterLevel().equals(MasterLevel.HEIATELMI)) {
            salary = 7000000;
            salary += (tedadTermeTadris * 1000000);
        } else if (master[masterIndex].getMasterLevel().equals(MasterLevel.HAGHOTADRIS))
            salary = (tedadTermeTadris * 1000000);

        return salary;
    }

    public Integer masterCheck(String username, String password) {
        int checkStats=0;
        for (int i = 0; i < masterIndex; i++) {
            if (master[i].getUserName().equals(username) && master[i].getPassword().equals(password))
                checkStats=1;
        }
        return checkStats;
    }
}
