package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain;






import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;


public interface IGeneralObject extends Serializable {

    public String getTableName();

    public String getColumnNamesForInsert();

    public String getInsertValues();

    public void setId(int id);
    
    public IGeneralObject getObject(ResultSet rs);
    
    public String getObjectCase();
    public List<IGeneralObject> getList(ResultSet rs);
    
}
