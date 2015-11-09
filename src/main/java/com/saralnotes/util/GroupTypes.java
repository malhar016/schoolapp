package com.saralnotes.util;

public enum GroupTypes {

	ClassRoom("ClassRoom"), ParentsGroup("ParentsGroup"), StudentsGroup(
			"StudentsGroup"), MixGroup("MixGroup");

	private String groupType;

	private GroupTypes(String groupTypeValue) {
		this.groupType = groupTypeValue;
	}

	public String getGroupType() {
		return groupType;
	}

}
