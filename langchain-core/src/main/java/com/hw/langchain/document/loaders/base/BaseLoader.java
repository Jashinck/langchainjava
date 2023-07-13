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

package com.hw.langchain.document.loaders.base;

import com.hw.langchain.schema.Document;

import java.util.List;

/**
 * Interface for loading documents.
 * <p>
 * Implementations should implement the lazy-loading method using generators
 * to avoid loading all documents into memory at once.
 *
 * @author HamaWhite
 */
public abstract class BaseLoader {

    /**
     * Load data into document objects.
     *
     * @return a List which is materialized in memory.
     */
    public abstract List<Document> load();

    protected String errorMessage(String filePath) {
        return "Error loading " + filePath;
    }

}
