package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain;






import java.io.Serializable;

// Operacije navedenog interfejsa je potrebno da implementira svaka od domenskih klasa,
// koja zeli da joj bude omogucena komunikacija sa Database broker klasom.
public interface IGeneralObject extends Serializable {

    public String getTableName();

    public String getColumnNamesForInsert();

    public String getInsertValues();

    public void setId(int id);

}
