/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author FON
 */
public class Equipment implements Serializable,IGeneralObject {
    //prototype
    public Equipment(Integer equipmentID) {
        this.equipmentID = equipmentID;
    }
   
    private Integer equipmentID;
    private String connection;
    private String specification;
    private String name;
    private List<Copy> copies;

    public Equipment(String connection, String specification, String name, List<Copy> copies) {
        this.connection = connection;
        this.specification = specification;
        this.name = name;
        this.copies = copies;
    }

    public Equipment() {
    }

    public Equipment(Integer equipmentID, String connection, String specification, String name) {
        this.equipmentID = equipmentID;
        this.connection = connection;
        this.specification = specification;
        this.name = name;
    }

    public Integer getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(Integer equipmentID) {
        this.equipmentID = equipmentID;
    }

    @Override
    public String toString() {
        return "Equipment{" + "equipmentID=" + equipmentID + ", connection=" + connection + ", specification=" + specification + ", name=" + name + ", copies=" + copies + '}';
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Copy> getCopies() {
      /*  if(copies==null)try {
            return ServerController.getInstance().getServiceCopy().getAllEquipment(equipmentID);
        } catch (Exception ex) {
            Logger.getLogger(Equipment.class.getName()).log(Level.SEVERE, null, ex);
        }
        return copies;*/
      return copies;
    }

    public void setCopies(List<Copy> copies) {
        this.copies = copies;
    }

    @Override
    public String getTableName() {
        return "equipment";
    }

    @Override
    public String getColumnNamesForInsert() {
       return "name,connection,specification"; }

    @Override
    public String getInsertValues() {
    StringBuilder sb = new StringBuilder();
      sb.append("'").append(name).append("','").append(connection).append("','")
                .append(specification).append("'");
        return sb.toString();    }

    @Override
    public void setId(int id) {
        equipmentID=id;
    }

}
