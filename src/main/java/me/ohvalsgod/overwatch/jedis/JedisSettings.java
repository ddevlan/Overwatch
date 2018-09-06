package me.ohvalsgod.overwatch.jedis;

import lombok.Getter;

@Getter
public class JedisSettings {

	private final String address;
	private final int port;
	private final String password;

	public JedisSettings(String address, int port, String password) {
		this.address = address;
		this.port = port;
		this.password = password;
	}

	public boolean hasPassword() {
		return this.password != null && !this.password.equals("");
	}

}
