<%-- Created on : Jul 3, 2023, 5:29:48 PM by DuyDuc94 --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="form-group">
    <input class="input" type="text" name="name" placeholder="${requestScope['name']!=null?requestScope['name']:'Full Name'}" required>
</div>
<div class="form-group">
    <input class="input" type="email" name="email" placeholder="Email" required>
</div>
<div class="form-group">
    <input class="input" type="text" name="address" placeholder="Address" required>
</div>
<div class="form-group">
    <input class="input" type="text" name="city" placeholder="City" required>
</div>
<div class="form-group">
    <input class="input" type="tel" name="tel" placeholder="Telephone" required>
</div>
