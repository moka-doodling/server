package com.doodling.submission.service;

import com.doodling.submission.dto.SubmissionRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.stream.IntStream;

@WebAppConfiguration // 모든 테스트에 어노테이션 추가
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:**/*-context.xml")
@Slf4j
public class SubmissionServiceTests {

  @Autowired
  public SubmissionService submissionService;

  private final static String sketch = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAPIAAAFtCAYAAAA9LzeGAAAAAXNSR0IArs4c6QAACL5JREFUeF7t0wERAAAIAjHtX9oc/s0GTNhxBAi8F9j3CQQgQGAMWQkIBAQMOfBEEQgYsg4QCAgYcuCJIhAwZB0gEBAw5MATRSBgyDpAICBgyIEnikDAkHWAQEDAkANPFIGAIesAgYCAIQeeKAIBQ9YBAgEBQw48UQQChqwDBAIChhx4oggEDFkHCAQEDDnwRBEIGLIOEAgIGHLgiSIQMGQdIBAQMOTAE0UgYMg6QCAgYMiBJ4pAwJB1gEBAwJADTxSBgCHrAIGAgCEHnigCAUPWAQIBAUMOPFEEAoasAwQCAoYceKIIBAxZBwgEBAw58EQRCBiyDhAICBhy4IkiEDBkHSAQEDDkwBNFIGDIOkAgIGDIgSeKQMCQdYBAQMCQA08UgYAh6wCBgIAhB54oAgFD1gECAQFDDjxRBAKGrAMEAgKGHHiiCAQMWQcIBAQMOfBEEQgYsg4QCAgYcuCJIhAwZB0gEBAw5MATRSBgyDpAICBgyIEnikDAkHWAQEDAkANPFIGAIesAgYCAIQeeKAIBQ9YBAgEBQw48UQQChqwDBAIChhx4oggEDFkHCAQEDDnwRBEIGLIOEAgIGHLgiSIQMGQdIBAQMOTAE0UgYMg6QCAgYMiBJ4pAwJB1gEBAwJADTxSBgCHrAIGAgCEHnigCAUPWAQIBAUMOPFEEAoasAwQCAoYceKIIBAxZBwgEBAw58EQRCBiyDhAICBhy4IkiEDBkHSAQEDDkwBNFIGDIOkAgIGDIgSeKQMCQdYBAQMCQA08UgYAh6wCBgIAhB54oAgFD1gECAQFDDjxRBAKGrAMEAgKGHHiiCAQMWQcIBAQMOfBEEQgYsg4QCAgYcuCJIhAwZB0gEBAw5MATRSBgyDpAICBgyIEnikDAkHWAQEDAkANPFIGAIesAgYCAIQeeKAIBQ9YBAgEBQw48UQQChqwDBAIChhx4oggEDFkHCAQEDDnwRBEIGLIOEAgIGHLgiSIQMGQdIBAQMOTAE0UgYMg6QCAgYMiBJ4pAwJB1gEBAwJADTxSBgCHrAIGAgCEHnigCAUPWAQIBAUMOPFEEAoasAwQCAoYceKIIBAxZBwgEBAw58EQRCBiyDhAICBhy4IkiEDBkHSAQEDDkwBNFIGDIOkAgIGDIgSeKQMCQdYBAQMCQA08UgYAh6wCBgIAhB54oAgFD1gECAQFDDjxRBAKGrAMEAgKGHHiiCAQMWQcIBAQMOfBEEQgYsg4QCAgYcuCJIhAwZB0gEBAw5MATRSBgyDpAICBgyIEnikDAkHWAQEDAkANPFIGAIesAgYCAIQeeKAIBQ9YBAgEBQw48UQQChqwDBAIChhx4oggEDFkHCAQEDDnwRBEIGLIOEAgIGHLgiSIQMGQdIBAQMOTAE0UgYMg6QCAgYMiBJ4pAwJB1gEBAwJADTxSBgCHrAIGAgCEHnigCAUPWAQIBAUMOPFEEAoasAwQCAoYceKIIBAxZBwgEBAw58EQRCBiyDhAICBhy4IkiEDBkHSAQEDDkwBNFIGDIOkAgIGDIgSeKQMCQdYBAQMCQA08UgYAh6wCBgIAhB54oAgFD1gECAQFDDjxRBAKGrAMEAgKGHHiiCAQMWQcIBAQMOfBEEQgYsg4QCAgYcuCJIhAwZB0gEBAw5MATRSBgyDpAICBgyIEnikDAkHWAQEDAkANPFIGAIesAgYCAIQeeKAIBQ9YBAgEBQw48UQQChqwDBAIChhx4oggEDFkHCAQEDDnwRBEIGLIOEAgIGHLgiSIQMGQdIBAQMOTAE0UgYMg6QCAgYMiBJ4pAwJB1gEBAwJADTxSBgCHrAIGAgCEHnigCAUPWAQIBAUMOPFEEAoasAwQCAoYceKIIBAxZBwgEBAw58EQRCBiyDhAICBhy4IkiEDBkHSAQEDDkwBNFIGDIOkAgIGDIgSeKQMCQdYBAQMCQA08UgYAh6wCBgIAhB54oAgFD1gECAQFDDjxRBAKGrAMEAgKGHHiiCAQMWQcIBAQMOfBEEQgYsg4QCAgYcuCJIhAwZB0gEBAw5MATRSBgyDpAICBgyIEnikDAkHWAQEDAkANPFIGAIesAgYCAIQeeKAIBQ9YBAgEBQw48UQQChqwDBAIChhx4oggEDFkHCAQEDDnwRBEIGLIOEAgIGHLgiSIQMGQdIBAQMOTAE0UgYMg6QCAgYMiBJ4pAwJB1gEBAwJADTxSBgCHrAIGAgCEHnigCAUPWAQIBAUMOPFEEAoasAwQCAoYceKIIBAxZBwgEBAw58EQRCBiyDhAICBhy4IkiEDBkHSAQEDDkwBNFIGDIOkAgIGDIgSeKQMCQdYBAQMCQA08UgYAh6wCBgIAhB54oAgFD1gECAQFDDjxRBAKGrAMEAgKGHHiiCAQMWQcIBAQMOfBEEQgYsg4QCAgYcuCJIhAwZB0gEBAw5MATRSBgyDpAICBgyIEnikDAkHWAQEDAkANPFIGAIesAgYCAIQeeKAIBQ9YBAgEBQw48UQQChqwDBAIChhx4oggEDFkHCAQEDDnwRBEIGLIOEAgIGHLgiSIQMGQdIBAQMOTAE0UgYMg6QCAgYMiBJ4pAwJB1gEBAwJADTxSBgCHrAIGAgCEHnigCAUPWAQIBAUMOPFEEAoasAwQCAoYceKIIBAxZBwgEBAw58EQRCBiyDhAICBhy4IkiEDBkHSAQEDDkwBNFIGDIOkAgIGDIgSeKQMCQdYBAQMCQA08UgYAh6wCBgIAhB54oAgFD1gECAQFDDjxRBAKGrAMEAgKGHHiiCAQMWQcIBAQMOfBEEQgYsg4QCAgYcuCJIhAwZB0gEBAw5MATRSBgyDpAICBgyIEnikDAkHWAQEDAkANPFIGAIesAgYCAIQeeKAIBQ9YBAgEBQw48UQQChqwDBAIChhx4oggEDFkHCAQEDDnwRBEIGLIOEAgIGHLgiSIQMGQdIBAQMOTAE0UgYMg6QCAgYMiBJ4pAwJB1gEBAwJADTxSBgCHrAIGAwAE9RwFukvjDDwAAAABJRU5ErkJggg==";

  /*

    private Integer submissionId;
    private Integer relayId;
    private Integer memberId;
    private Integer week;
    private String content;
    private String sketch;
   */
  @Test
  public void registerSubmission() {
    IntStream.range(0, 100).forEach(i -> {
      submissionService.registerSubmission(
              SubmissionRequestDTO.builder()
                      .relayId((i % 8) + 1)
                      .memberId(i + 1)
                      .week((i % 4) + 1) // 1 ~ 4
                      .content("content" + i)
                      .sketch(sketch)
                      .build());
    });
  }
}
