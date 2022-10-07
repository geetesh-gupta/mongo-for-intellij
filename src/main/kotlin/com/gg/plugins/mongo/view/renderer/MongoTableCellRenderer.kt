/*
 * Copyright (c) 2018 David Boissier.
 * Modifications Copyright (c) 2022 Geetesh Gupta.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gg.plugins.mongo.view.renderer

import com.gg.plugins.mongo.view.style.StyleAttributesProvider
import com.intellij.ui.ColoredTableCellRenderer
import org.bson.Document
import org.bson.types.ObjectId
import javax.swing.JTable

class MongoTableCellRenderer : ColoredTableCellRenderer() {
    override fun customizeCellRenderer(
        table: JTable,
        value: Any?,
        selected: Boolean,
        hasFocus: Boolean,
        row: Int,
        column: Int
    ) {
        when (value) {
            (value == null) -> append("null", StyleAttributesProvider.nullAttribute)
            is Number -> append(value.toString(), StyleAttributesProvider.numberAttribute)
            is Boolean -> append(value.toString(), StyleAttributesProvider.booleanAttribute)
            is Document -> append(value.toJson(), StyleAttributesProvider.documentAttribute)
            is ObjectId -> append(value.toString(), StyleAttributesProvider.objectIdAttribute)
            else -> append(value.toString(), StyleAttributesProvider.stringAttribute)
        }
    }
}