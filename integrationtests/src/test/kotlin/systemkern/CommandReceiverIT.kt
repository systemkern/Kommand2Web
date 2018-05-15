package systemkern

import org.junit.Test
import org.springframework.http.MediaType
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post
import org.springframework.restdocs.payload.JsonFieldType.ARRAY
import org.springframework.restdocs.payload.JsonFieldType.STRING
import org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import org.springframework.restdocs.payload.PayloadDocumentation.responseFields
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

internal class CommandReceiverIT : IntegrationTest() {

    @Test fun `Can Receive Commands via Post`() {
        this.mockMvc.perform(
            post("/execute-command")
                .accept(MediaType.APPLICATION_JSON))
            .andDo(document("execute-command-post",
                responseFields(
                    fieldWithPath("timestamp").description("current server timestamp").type(ARRAY),
                    fieldWithPath("output").description("shell output of the command").type(STRING)
                )
            ))
            .andExpect(status().isOk)
    }


    @Test fun `Can Receive Commands via Get`() {
        this.mockMvc.perform(
            get("/execute-command")
                .accept(MediaType.APPLICATION_JSON))
            .andDo(document("execute-command-get",
                responseFields(
                    fieldWithPath("timestamp").description("current server timestamp").type(ARRAY),
                    fieldWithPath("output").description("shell output of the command").type(STRING)
                )
            ))
            .andExpect(status().isOk)
    }
}