<%-- 
    Document   : forminsertsiswa
    Created on : Nov 29, 2013, 2:30:46 PM
    Author     : Dery
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center><h1><u>Form Input Data Siswa</u></h1></center>
        <form action="insertactionsiswa.jsp" method="POST">
            <table border="0" align="center">
                <tr>
                <td>NIS SISWA</td>
                <td><input type="text" name="txtNis"></td>
                </tr>
                <tr>
                <td>NAMA SISWA</td>
                <td><input type="text" name="txtNama"></td>
                </tr>
                <tr>
                <td>ALAMAT SISWA</td>
                <td><input type="text" name="txtAlamat"></td>
                </tr>
                <tr> 
                <td>NO TELEPON</td>
                <td><input type="text" name="txtNoTelp"></td>
                </tr>
                <tr>
                <td></td>
                <br>
                <td></td>
                </tr>
                <tr>
                <td></td>
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
        background-color: grey;
     }   
 table {
     padding: 50px;       
     border: 5px dashed pink;
        }
</style>
