/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.kenyaemr.calculation.library.rdqa;

import org.openmrs.Visit;
import org.openmrs.calculation.patient.PatientCalculationContext;
import org.openmrs.calculation.result.CalculationResultMap;
import org.openmrs.calculation.result.ListResult;
import org.openmrs.calculation.result.SimpleResult;
import org.openmrs.module.kenyacore.calculation.AbstractPatientCalculation;
import org.openmrs.module.kenyacore.calculation.CalculationUtils;
import org.openmrs.module.kenyacore.report.data.patient.definition.VisitsForPatientDataDefinition;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Calculates the total no of visits for a patient
 */
public class VisitsForAPatientCalculation extends AbstractPatientCalculation {

	@Override
	public CalculationResultMap evaluate(Collection<Integer> cohort, Map<String, Object> parameterValues, PatientCalculationContext context) {

		VisitsForPatientDataDefinition definition = new VisitsForPatientDataDefinition();
		CalculationResultMap data = CalculationUtils.evaluateWithReporting(definition, cohort, parameterValues, null, context);
		CalculationResultMap ret = new CalculationResultMap();

		for (Integer ptid : cohort) {
			ListResult result = (ListResult) data.get(ptid);
			List<Visit> visits = CalculationUtils.extractResultValues(result);
			Integer noOfVisits = visits != null && visits.size() > 0? visits.size(): 0;
			ret.put(ptid, new SimpleResult(noOfVisits, this));
		}

		return ret;
	}
}
