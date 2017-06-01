<%@tag description="button to do actions defined on the data table" pageEncoding="UTF-8"%>

<%@attribute name="panelTable" required="true"%>
<%@attribute name="action" required="true"%>
<%@attribute name="icon" required="true"%>

<button type="button" 
        class="btn btn-primary tableButton" 
        data-panel-table="${panelTable}"
        data-action="${action}">
    <span class="${icon}"></span> <jsp:doBody />
</button>