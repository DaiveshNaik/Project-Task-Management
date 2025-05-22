package com.daivesh.service;

import com.daivesh.exception.MailsException;
import com.daivesh.model.Invitation;
import jakarta.mail.MessagingException;

public interface InvitationService {

	public void sendInvitation(String email, Long projectId) throws MailsException, MessagingException;

	public Invitation acceptInvitation(String token, Long userId) throws Exception;

	public String getTokenByUserMail(String userEmail);

	public void deleteToken(String token);
}
