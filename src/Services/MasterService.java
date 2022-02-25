package Services;

import Entity.Master;
import Repository.MasterRepository;

public class MasterService {
    MasterRepository masterRepository = new MasterRepository();
    Integer number = 0;

    public void signUp(Master master) {
        try {
            masterRepository.signUpMaster(master);
        } catch (Exception e) {
            System.out.println("an error has occur! ");
        }
    }

    public void remove(Integer index) {
        try {
            masterRepository.removeMaster(index);
        } catch (Exception e) {
            System.out.println("an error has occur! ");
        }
    }

    public void edit(Integer index, Master master) {
        try {
            masterRepository.editMaster(index, master);
        } catch (Exception e) {
            System.out.println("an error has occur! ");
        }
    }

    public void masterInfo(Integer index) {
        try {
            masterRepository.masterInfo(index);
        } catch (Exception e) {
            System.out.println("an error has occur! ");
        }
    }

    public Integer payslip(Integer masterIndex, Integer tedadTermeTadris) {
        number = 0;
        try {
            number = masterRepository.paySlip(masterIndex, tedadTermeTadris);
        } catch (Exception e) {
            System.out.println("an error has occur! ");
        }
        return number;
    }

    public Integer masterCheck(String username, String password) {
        number = 0;
        try {
            number = masterRepository.masterCheck(username, password);
        } catch (Exception e) {
            System.out.println("an error has occur! ");
        }
        return number;
    }

}
