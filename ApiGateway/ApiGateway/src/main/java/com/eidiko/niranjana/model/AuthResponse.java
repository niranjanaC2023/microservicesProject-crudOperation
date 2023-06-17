package com.eidiko.niranjana.model;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@Getter
public class AuthResponse 
{

	private String userId;
	private String accessToken;
	private String refreshToken;
	private long expieAt;
	private Collection<String> authorities;
}
