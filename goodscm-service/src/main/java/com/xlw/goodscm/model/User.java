package com.xlw.goodscm.model;

import java.io.Serializable;

import com.xlw.sys.model.SysUser;

@Deprecated
public class User extends SysUser {
	private static final long serialVersionUID = 1L;
	private Serializable sessionId;

	public Serializable getSessionId() {
		return sessionId;
	}

	public void setSessionId(Serializable sessionId) {
		this.sessionId = sessionId;
	}

}