/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.kenyaemr.fragment.controller.prescription;

import org.openmrs.Patient;
import org.openmrs.module.kenyaemr.EmrWebConstants;
import org.openmrs.module.kenyaemr.regimen.RegimenJsonGenerator;
import org.openmrs.ui.framework.annotation.FragmentParam;
import org.openmrs.ui.framework.fragment.FragmentModel;

/**
 * Patient drugs orders fragment
 */
public class RegimenJsonGeneratorFragmentController {

	public void controller(/*@FragmentParam("patient") Patient patient, */FragmentModel model) {

		model.put("regimenJson", new RegimenJsonGenerator().generateRegimenJsonFromRegimensConfigFile());
		//System.out.println("Testing output: \n" + new RegimenJsonGenerator().getCurrentRegimens(patient));
	}

}