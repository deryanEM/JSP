<%-- 
    Document   : forminsertkelas
    Created on : Dec 3, 2013, 9:36:21 AM
    Author     : Dibaj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center><h1><u>Form Input Data Kelas</u></h1></center>
        <form action="insertactionkelas.jsp" method="POST">
                <table border="0" align="center">
                <tr>
                <td>Kode Kelas</td>
                <td><input type="text" name="txtKode"></td>
                </tr>
                <tr>
                <td>Jurusan</td>
                <td><input type="text" name="txtJurusan"></td>
                </tr>
                <tr>
                <td>Nama Kelas</td>
                <td><input type="text" name="txtNama"></td>
                </tr>
                <tr> 
                <td>Ketua Kelas</td>
                <td><input type="text" name="txtKetua"></td>
                </tr>
                <tr>
                <td>Wali Kelas</td>
                <td><input type="text" name="txtWali"></td>
                </tr>
                <tr>
                <td>Jumlah Siswa</td>
                <td><input type="text" name="txtJumlah"></td>
                </tr>
                <tr>
                <td></td>
                <br>
                <td></td>
                </tr>
                <tr>
                <td></td>
                <br>
                <td align="center"><input type="submit" value="Submit"></td>
                </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>

<style type="text/css">
 body {
        padding:50px;
     }   
 table {
     padding: 50px;       
     border: 5px dashed pink;
        }
</style>