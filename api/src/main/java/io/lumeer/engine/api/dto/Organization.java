/*
 * -----------------------------------------------------------------------\
 * Lumeer
 *  
 * Copyright (C) 2016 - 2017 the original author or authors.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * -----------------------------------------------------------------------/
 */
package io.lumeer.engine.api.dto;

import io.lumeer.engine.api.LumeerConst;
import io.lumeer.engine.api.data.DataDocument;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.concurrent.Immutable;

/**
 * DTO object for Organization
 */
@Immutable
public class Organization {

   private final String name;
   private final String code;
   private final String icon;
   private final String color;

   public Organization(final DataDocument dataDocument) {
      this(dataDocument.getString(LumeerConst.Organization.ATTR_ORG_CODE),
            dataDocument.getString(LumeerConst.Organization.ATTR_ORG_NAME),
            dataDocument.getString(LumeerConst.Organization.ATTR_META_ICON),
            dataDocument.getString(LumeerConst.Organization.ATTR_META_COLOR));
   }

   public Organization(final String code, final String name){
      this(code, name, null, null);
   }

   @JsonCreator
   public Organization(final @JsonProperty("code") String code,
         final @JsonProperty("name") String name,
         final @JsonProperty("icon") String icon,
         final @JsonProperty("color") String color) {
      this.code = code;
      this.name = name;
      this.icon = icon;
      this.color = color;
   }

   public String getName() {
      return name;
   }

   public String getCode() {
      return code;
   }

   public String getIcon() {
      return icon;
   }

   public String getColor() {
      return color;
   }

   public DataDocument toDataDocument() {
      return new DataDocument(LumeerConst.Organization.ATTR_ORG_CODE, code)
            .append(LumeerConst.Organization.ATTR_ORG_NAME, name)
            .append(LumeerConst.Organization.ATTR_META_COLOR, color)
            .append(LumeerConst.Organization.ATTR_META_ICON, icon);
   }

}
