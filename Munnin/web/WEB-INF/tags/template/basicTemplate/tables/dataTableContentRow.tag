<%@tag description="tag used to show the information in rows" pageEncoding="UTF-8"%>

<%@attribute name="idRow" required="true"%>
<%@attribute name="idTable" required="true"%>

<tr data-id="${idRow}" 
    data-data-table="${idTable}">
    <jsp:doBody />
</tr>