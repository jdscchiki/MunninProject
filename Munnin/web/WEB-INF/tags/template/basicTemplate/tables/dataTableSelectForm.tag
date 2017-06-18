<%@tag description="tag used to send information on selection on dataTables" pageEncoding="UTF-8"%>

<%@attribute name="id" required="true"%>
<%@attribute name="urlServlet" required="true"%>
<%@attribute name="display" required="true"%>
<%@attribute name="dataTable" required="true"%>

<form id="${id}"
      method="POST"
      action="${urlServlet}"
      data-display="${display}"
      data-data-table="${dataTable}">
    <input type="hidden" name="id" value="-1" data-selected-item="">
    <input type="hidden" name="action" data-action="">    
</form>