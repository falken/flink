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

package org.apache.flink.table.runtime.connector.sink;

import org.apache.flink.table.connector.sink.DynamicTableSink;
import org.apache.flink.table.data.util.DataFormatConverters.DataFormatConverter;

import javax.annotation.Nullable;

/**
 * This class wraps a {@link DataFormatConverter} so it can be used in
 * a {@link DynamicTableSink} as a {@link DynamicTableSink.DataStructureConverter}.
 */
public final class DataFormatConverterWrapper implements DynamicTableSink.DataStructureConverter {

	private static final long serialVersionUID = 1L;

	private final DataFormatConverter<Object, Object> formatConverter;

	public DataFormatConverterWrapper(DataFormatConverter<Object, Object> formatConverter) {
		this.formatConverter = formatConverter;
	}

	@Override
	public void open(Context context) {
		// do nothing
	}

	@Nullable
	@Override
	public Object toExternal(@Nullable Object internalStructure) {
		return formatConverter.toExternal(internalStructure);
	}
}
