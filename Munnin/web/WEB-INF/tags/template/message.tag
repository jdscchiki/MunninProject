<%@tag description="usual message model of the application" pageEncoding="UTF-8"%>

<%@attribute name="message" required="true"%>
<%@attribute name="type" required="true"%>

<div class="alert alert-${type} alert-dismissable">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  ${message}
</div>
