/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.srp.controller;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;
import javax.servlet.jsp.tagext.TagSupport;
import org.springframework.data.domain.Page;

/**
 *
 * @author DeNiSa
 */
public class Paging extends TagSupport {

    private Page paging;
    private String url = "";

    @Override
    public int doStartTag() throws JspException {
        try {
            StringBuilder out = new StringBuilder();
            out.append("<nav aria-label=\"Page navigation\">");
            out.append((paging.getNumber() + 1));
            out.append("/");
            out.append((paging.getTotalPages()));
            out.append("</p>");
            out.append("<ul class=\"pagination\">");

            //first & previous
            if (paging.isFirst()) {
                out.append("<li class=\"disabled\"><span>First</span></li>");
                out.append("<li class=\"disabled\"><span>&laquo;</span></li>");
            } else {
                out.append("<li>");
                out.append("<a href=\"").append(url).append("?page=1").append("\">First</a>");
                out.append("</li>");

                out.append("<li>");
                out.append("<a href=\"").append(url).append("?page=").append((paging.getNumber())).append("\">&laquo;</a>");
                out.append("</li>");
            }

            //page number
            for (int i = 1; i <= paging.getTotalPages(); i++) {
                if ((i-1) == paging.getNumber()) {
                    out.append("<li class=\"active\"><span>");
                    out.append(i);
                    out.append("</span></li> ");
                } else {
                    out.append("<li><a href=\"");
                    out.append(url).append("?page=").append(i);
                    out.append("\">").append(i).append("</a></li> ");
                }
            }

            //next & last
            if (!paging.hasNext() && paging.isLast()) {
                out.append("<li class=\"disabled\"><span>&raquo;</span></li>");
                out.append("<li class=\"disabled\"><span>Last</span></li>");
            } else {
                out.append("<li>");
                out.append("<a href=\"").append(url).append("?page=").append((paging.getNumber() + 2)).append("\">&raquo;</a>");
                out.append("</li>");

                out.append("<li>");
                out.append("<a href=\"").append(url).append("?page=").append((paging.getTotalPages())).append("\">Last</a>");
                out.append("</li>");

            }
            out.append("</ul>");
            out.append("</nav>");

            pageContext.getOut().println(out.toString());
        } catch (IOException e) {
            System.out.println("error");
        }
        return SKIP_BODY;
    }

    @Override
    public void release() {
        super.release();
        paging = null;
        url = "";
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Page getPaging() {
        return paging;
    }

    public void setPaging(Page paging) {
        this.paging = paging;
    }

}
