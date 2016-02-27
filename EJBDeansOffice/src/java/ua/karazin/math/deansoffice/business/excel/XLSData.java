/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.karazin.math.deansoffice.business.excel;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import ua.karazin.math.deansoffice.business.GroupLogic;
import ua.karazin.math.deansoffice.business.StudentLogic;
import ua.karazin.math.deansoffice.view.MarkSheet.StatementGroupList;
import ua.karazin.math.deansoffice.view.Student.StudentListView;

/**
 *
 * @author Такасу
 */
@Stateless
@LocalBean
public class XLSData {
    @EJB
    CreateXLS stdXLog;
    @EJB
    StudentLogic stdLog;
    @EJB
    GroupLogic grpLog;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
          public byte[] StudentFullList() throws IOException{
              List<StudentListView> StdListV = stdLog.getStudList();
	    int i=1;
            Map<Integer, Object[]> data = new HashMap<Integer, Object[]>();
            
	    data.put(0, new Object[] {"Имя", "Отчество", "Фамилия", "День Рождения", "Семейный Статус", "Адрес Регистрации", "Текущий Адрес", "Телефон",
            "Информация о Родителях", "Идентификационный Код", "Номер Читательского Билета", "Email", "Номер Паспорта", "Гражданство", "Среднее Образование"});
	    for(StudentListView tmp : StdListV){  
	    data.put(i, new Object[] {StdListV.get(i-1).getFirstName(), StdListV.get(i-1).getSecondName(), StdListV.get(i-1).getLastName()
            ,StdListV.get(i-1).getBirthday(),StdListV.get(i-1).getMaritalStatus(),StdListV.get(i-1).getRegistrationAdress(),StdListV.get(i-1).getCurrentAdress(),
            StdListV.get(i-1).getPhone(),StdListV.get(i-1).getParentsInfo(),StdListV.get(i-1).getIDCCode(),StdListV.get(i-1).getLibNumber(), StdListV.get(i-1).getE_mail(),
            StdListV.get(i-1).getPassportNum(), StdListV.get(i-1).getCitizenship(),StdListV.get(i-1).getPreviousEducation()});
	    i++;
	    } 
            return stdXLog.CreateXLSfile(data, "Students_List");
          }
          
          public byte[] StudentGroupList(String GroupName) throws IOException{
              List<StatementGroupList> StdGrpListV = grpLog.FindStudListByGroup(GroupName);
	    int i=1;
            Map<Integer, Object[]> data = new HashMap<Integer, Object[]>();
            
	    data.put(0, new Object[] {"Имя", "Отчество", "Фамилия", "Номер Студенческого", "Номер Зачетной Книжки", "Группа"});
	    for(StatementGroupList tmp : StdGrpListV){
	    data.put(i, new Object[] {StdGrpListV.get(i-1).getFirstName(), StdGrpListV.get(i-1).getSecondName(), StdGrpListV.get(i-1).getLastName()
            ,Integer.toString(StdGrpListV.get(i-1).getStudNum()),StdGrpListV.get(i-1).getPlan(),StdGrpListV.get(i-1).getGroupName()});
	    i++;
	    } 
            return stdXLog.CreateXLSfile(data, "Students_Group_List");
          }
           
}
