package com.medeil.bean;

import java.util.List;

public class LangBean {

	List<ActionIndication> actionIndications;
	List<PotentialSideEffects> potentialsideeffects;
	List<ProductInformation> productInformations;
	public List<ActionIndication> getActionIndications() {
		return actionIndications;
	}
	public void setActionIndications(List<ActionIndication> actionIndications) {
		this.actionIndications = actionIndications;
	}
	public List<PotentialSideEffects> getPotentialsideeffects() {
		return potentialsideeffects;
	}
	public void setPotentialsideeffects(List<PotentialSideEffects> potentialsideeffects) {
		this.potentialsideeffects = potentialsideeffects;
	}
	public List<ProductInformation> getProductInformations() {
		return productInformations;
	}
	public void setProductInformations(List<ProductInformation> productInformations) {
		this.productInformations = productInformations;
	}
}
