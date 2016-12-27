<%@page import="modelo.bean.Funcionario"%>
<%@page import="modelo.bean.Rol"%>
<%@page import="java.util.ArrayList"%>
<form id="formAssignRole" class="form-horizontal" role="form" method="POST" action="${URICoordinator}assign-roles">
    <div id="assignRole" class="modal fade" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Administrar role del funcionario</h4>
                </div>
                <div class="modal-body">
                    <%
                        if (request.getAttribute("roles") != null && request.getAttribute("funcionario") != null) {
                            ArrayList<Rol> roles = (ArrayList<Rol>) request.getAttribute("roles");
                            Funcionario funcionario = (Funcionario) request.getAttribute("funcionario");
                            if (!roles.isEmpty()) {
                    %>
                    <div class="form-group">
                        <label class="control-label col-lg-3">Funcionario :</label>
                        <div class="col-lg-4">
                            <p class="form-control-static">
                                <%=funcionario.getNombre()+ " " + funcionario.getApellido()%>
                            </p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-3">Roles :</label>
                        <div class="col-lg-4">
                            <input type="hidden" name="id" value="<%=funcionario.getId()%>">
                            <%
                                for (int i = 0; i < roles.size(); i++) {
                                    boolean selected = false;
                                    for (int j = 0; j < funcionario.getRoles().size(); j++) {
                                        if (roles.get(i).getId() == funcionario.getRoles().get(j).getId()) {
                                            selected = true;
                                            break;
                                        }
                                    }
                            %>
                            <div class="checkbox">
                                <label><input type="checkbox" name="role" value="<%=roles.get(i).getId()%>" <%=selected ? "checked" : ""%>><%=roles.get(i).getNombre()%></label>
                            </div>
                            <%
                                        }
                                    }
                                }
                            %>
                        </div>
                    </div>
                    <div class="form-group">
                        <div id="formAssignRole_message" class="col-lg-offset-3 col-lg-8">

                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-success">Guardar</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                </div>
            </div>
        </div>
    </div>
</form>