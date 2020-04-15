<%-- 
    Document   : giris
    Created on : 13 Nis 2020, 08:09:33
    Author     : taner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Giris</title>
</head>
<body>
    <% 
        Object hataObj = request.getAttribute("hata");
        String hataMesaj ="";
        if (hataObj != null )
            hataMesaj = String.valueOf(hataObj);
        
    %>
    
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    
    <form method="post" action="girisKontrol">
        <center> <font color="red"/> <%= hataMesaj %> </center>
        
        
        <table align="center" border="1">
            <tr>
                <td colspan="2" align="center" bgcolor="blue"><font color="white"> <b>Giris Ekrani</b></font></td>

            </tr>

            <tr>
                <td>Kullanici Adi:</td>
                <td> <input type="text" name="ad"/>   </td>

            </tr>

            <tr>
                <td>Sifre :</td>
                <td> <input type="password" name="sifre"/>  </td>  
            </tr>

            <tr>
                <td colspan="2" align="center"> <input type="submit" value="Giris"/> </td>

            </tr>





        </table>

    </form>




</body>
</html>
