package com.gabrielnz.msguser.entities.DTO;

import java.util.UUID;

public record EmailDTO(UUID userID, String emailTo, String subject, String text) {
}
