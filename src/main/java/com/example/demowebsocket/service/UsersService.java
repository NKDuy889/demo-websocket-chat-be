package com.example.demowebsocket.service;

import com.example.demowebsocket.model.Users;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public interface UsersService<E> {
    List<E> getAllUsers();

    public static void main(String[] args) throws IOException {
        try {
            List<Integer> users = new ArrayList<Integer>();
            List<Users> lst = new ArrayList<>();
            FileInputStream excelFile = new FileInputStream("C:\\Users\\Administrator\\Documents\\PubList.xlsx");
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
            Row row = iterator.next();
//            iterator.next();
            DataFormatter fmt = new DataFormatter();
            while (iterator.hasNext()) {
                Users u = new Users();
                Row currentRow = iterator.next();
                if (!"".equals(currentRow.getCell(1).toString().trim()) && !"".equals(currentRow.getCell(3).toString().trim())) {
                    u.setAvatar(fmt.formatCellValue(currentRow.getCell(1)));
                    u.setName(fmt.formatCellValue(currentRow.getCell(3)));
                    lst.add(u);
                } else {
                    users.add(currentRow.getRowNum() + 1);
                }
            }
            for (Users data:lst) {
                System.out.println(data);
            }
            System.out.println("Ban ghi sai" + users);
            List<String> a = new ArrayList<String>();
            a.add("{\"name\":\"Đoàn Thế Bình\",\"avatar\":\"HUt.edu.vn$86\"}");
            a.add("{\"name\":\"Nguyễn Thị Mỹ Hằng\"}");
            ObjectMapper objectMapper = new ObjectMapper();
            Users userss = objectMapper.readValue(a.get(1),Users.class);
            System.out.println(userss);
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
