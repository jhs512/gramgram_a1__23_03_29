package com.ll.gramgram.boundedContext.instaMember.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/instaMember")
@RequiredArgsConstructor
public class InstaMemberController {
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/connect")
    public String showConnect() {
        return "usr/instaMember/connect";
    }
}
