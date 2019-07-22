package com.jazzteam.service;

import com.jazzteam.constants.ExceptionMessage;
import com.jazzteam.exception.MyException;
import com.jazzteam.model.mail.MailDistributionList;
import com.jazzteam.model.mail.MailTemplate;

import java.util.ArrayList;

public class MailService {
    private MailService() {

    }

    /**
     * Method deleting of mail distribution list
     *
     * @param mailDistributionList object for deleting
     * @throws NullPointerException if received mail distribution list is null
     * @throws MyException          if received mail distribution list is empty
     */
    public void deleteDistributionList(MailDistributionList mailDistributionList) throws MyException {
        if (mailDistributionList == null) {
            throw new NullPointerException(ExceptionMessage.MAIL_DISTRIBUTION_LIST_IS_NULL);
        }
        if (mailDistributionList.equals(new MailDistributionList())) {
            throw new MyException(ExceptionMessage.MAIL_DISTRIBUTION_LIST_IS_EMPTY);
        }
        for (int i = 0; i < AuditorService.findAllMailDistributionLists().size(); i++) {
            if (AuditorService.findAllMailDistributionLists().get(i).equals(mailDistributionList)) {
                AuditorService.findAllMailDistributionLists().remove(i);
                break;
            }
        }
    }

    /**
     * Editing method for mail distribution entity
     *
     * @param distributionListId id of edited mail distribution list
     * @param newName            new name for mail distribution list
     * @param newEmailsList      new emails list for mail distribution list
     * @return edited mail distribution list obj
     */
    public MailDistributionList editDistributionList(int distributionListId, String newName, ArrayList<String> newEmailsList) throws MyException {
        if (AuditorService.findAllMailDistributionLists().get(distributionListId).equals(new MailDistributionList())) {
            throw new MyException(ExceptionMessage.MAIL_DISTRIBUTION_LIST_IS_EMPTY);
        }
        if (AuditorService.findAllMailDistributionLists().get(distributionListId) == null) {
            throw new NullPointerException(ExceptionMessage.MAIL_DISTRIBUTION_LIST_IS_NULL);
        }

        AuditorService.findAllMailDistributionLists().get(distributionListId).setEmails(newEmailsList);
        AuditorService.findAllMailDistributionLists().get(distributionListId).setName(newName);
        return AuditorService.findAllMailDistributionLists().get(distributionListId);
    }

    /**
     * Deleting method for Mail template
     *
     * @param mailTemplate obj for deleting
     * @throws NullPointerException if received mail template is null
     * @throws MyException          if received mail template is empty
     */
    public void deleteMailTemplate(MailTemplate mailTemplate) throws MyException {
        if (mailTemplate == null) {
            throw new NullPointerException(ExceptionMessage.MAIL_TEMPLATE_IS_NULL);
        }
        if (mailTemplate.equals(new MailTemplate())) {
            throw new MyException(ExceptionMessage.MAIL_TEMPLATE_IS_EMPTY);
        }
        for (int i = 0; i < AuditorService.findAllMailTemplates().size(); i++) {
            if (AuditorService.findAllMailTemplates().get(i).equals(mailTemplate)) {
                AuditorService.findAllMailTemplates().remove(i);
                break;
            }
        }
    }

    /**
     * Editing method for Mail Template
     *
     * @param mailTemplateId  mail template id
     * @param newTemplateName new name for edited mail template
     * @param newTemplateText new template text for edited mail template
     * @return edited mail template obj
     */
    public MailTemplate editMailTemplate(int mailTemplateId, String newTemplateName, String newTemplateText) throws MyException {
        if (AuditorService.findAllMailTemplates().get(mailTemplateId).equals(new MailTemplate())) {
            throw new MyException(ExceptionMessage.MAIL_TEMPLATE_IS_EMPTY);
        }

        if (AuditorService.findAllMailTemplates().get(mailTemplateId) == null) {
            throw new NullPointerException(ExceptionMessage.MAIL_TEMPLATE_IS_NULL);
        }
        AuditorService.findAllMailTemplates().get(mailTemplateId).setName(newTemplateName);
        AuditorService.findAllMailTemplates().get(mailTemplateId).setTemplateText(newTemplateText);
        return AuditorService.findAllMailTemplates().get(mailTemplateId);
    }
}
