<%
	def kenyaEmrWebUtils = context.loadClass("org.openmrs.module.kenyaemr.util.KenyaEmrWebUtils")

	config.require("id")
	config.require("concepts")
%>

<table class="decorated" id="${ config.id }" style="${ config.style ? config.style : "" }">
	<thead>
	<tr>
		<th>Date</th>
		<% concepts.each { %>
		<th nowrap="nowrap">${ ui.format(it) }</th>
		<% } %>
	</tr>
	</thead>
	<tbody>
	<% if (!data) { %>
	<tr>
		<td></td>
		<td colspan="${ concepts.size() }">${ ui.message("general.none") }</td>
	</tr>
	<% } %>
	<% data.each { date, results -> %>
	<tr>
		<td nowrap="nowrap"><%= kenyaEmrWebUtils.formatDateNoTime(date) %></td>
		<% concepts.each { concept -> %>
		<td style="text-align: right">
			<%
			def obs = results[concept]
			if (obs) {
			%>
				${ ui.format(obs) }
			<% } %>
		</td>
		<% } %>
	</tr>
	<% } %>
	</tbody>
</table>