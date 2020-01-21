/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FON
 */
public class Copy implements Serializable, IGeneralObject {

    private Integer copyID;
    private Boolean working;
    private Boolean available;
    private Equipment equipment;
    private String defect;
//prototype

    public Copy(Integer copyID, Integer equipmentID) {
        this.equipment = new Equipment(equipmentID);
        this.copyID = copyID;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.copyID);
        hash = 97 * hash + Objects.hashCode(this.working);
        hash = 97 * hash + Objects.hashCode(this.available);
        hash = 97 * hash + Objects.hashCode(this.equipment);
        hash = 97 * hash + Objects.hashCode(this.defect);
        return hash;
    }

    @Override
    public String toString() {
        return "Copy " + copyID;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Copy other = (Copy) obj;
        if (!Objects.equals(this.copyID, other.copyID)) {
            return false;
        }
        if (!Objects.equals(this.equipment, other.equipment)) {
            return false;
        }
        return true;
    }

    public Copy() {
        this.working = true;
        this.available = true;
        this.defect = "";
    }

    public Copy(Integer copyID, Boolean working, Boolean available, Equipment equipment, String defect) {
        this.copyID = copyID;
        this.working = working;
        this.available = available;
        this.equipment = equipment;
        this.defect = defect;
    }

    public String getDefect() {
        return defect;
    }

    public void setDefect(String defect) {
        this.defect = defect;
    }

    public Integer getCopyID() {
        return copyID;
    }

    public void setCopyID(Integer copyID) {
        this.copyID = copyID;
    }

    public Boolean getWorking() {
        return working;
    }

    public void setWorking(Boolean working) {
        this.working = working;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String getTableName() {
        return "copy";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "equipmentID,working,available,defect";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(equipment.getEquipmentID()).append(",")
                .append(working.compareTo(false)).append(",")
                .append(available.compareTo(false)).append(",'").append(defect).append("'");
        return sb.toString();
    }

    @Override
    public void setId(int id) {
        copyID = id;
    }

    @Override
    public IGeneralObject getObject(ResultSet rs) {
        Copy z = new Copy();
        try {
            z.setCopyID(rs.getInt("copyID"));
            z.setDefect(rs.getString("defect"));
            z.setWorking(rs.getBoolean("working"));
            z.setAvailable(rs.getBoolean("available"));

        } catch (SQLException e) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e);
        }
        return z;
    }

    @Override
    public String getObjectCase() {
        return "equipmentID = " + equipment.getEquipmentID();
    }

    @Override
    public List<IGeneralObject> getList(ResultSet rs) {
        List<IGeneralObject> list = new ArrayList<>();
        try {
            Copy z = new Copy();
            while (rs.next()) {
                z.setCopyID(rs.getInt("copyID"));
                z.setDefect(rs.getString("defect"));
                z.setWorking(rs.getBoolean("working"));
                z.setAvailable(rs.getBoolean("available"));

                list.add(z);
            }
        } catch (SQLException e) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;

    }

}
