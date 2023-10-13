/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hw.langchain.llms.openai;

import com.hw.langchain.base.language.BaseLanguageModel;
import lombok.var;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * OpenAITest
 *
 * @author HamaWhite
 */
@Disabled("Test requires costly OpenAI calls, can be run manually.")
class OpenAITest {

    @Test
    void testPredict() {
        var llm = OpenAI.builder()
                .temperature(0)
                .maxTokens(16)
                .requestTimeout(16)
                .build()
                .init();

        var result = llm.predict("Say this is a test");
        assertThat(result).isEqualTo("\n\nThis is indeed a test.");
    }

    @Test
    void testAsyncPredict() {
        var llm = OpenAI.builder()
                .temperature(0)
                .maxTokens(1600)
                .requestTimeout(120)
                .build()
                .init();

        Flux<String> result = llm.asyncPredict("Say this is a test");

        List<String> resultList = result.collectList().block();
        assertThat(resultList).isEqualTo(Arrays.asList("\n", "\n", "This", " is", " indeed", " a", " test", ".", ""));
    }
}