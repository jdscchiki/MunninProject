<%@tag description="form used to basic search" pageEncoding="UTF-8"%>

<%@attribute name="id" required="true"%>
<%@attribute name="urlServlet" required="true"%>
<%@attribute name="display" required="true"%>
<%@attribute name="placeholder" required="true"%>
<%@attribute name="width" required="true" type="Integer"%>

<form id="${id}" 
      class="form-horizontal" 
      method="POST" 
      action="${urlServlet}"
      data-ajax-form="true"
      data-display="${display}">
    <div class="form-group">
        <div class="col-sm-${width}">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="${placeholder}" name="search">
                <div class="input-group-btn">
                    <button class="btn btn-default" type="submit">
                        <i class="glyphicon glyphicon-search"></i>
                    </button>
                </div>
            </div>
        </div>
    </div>
</form>