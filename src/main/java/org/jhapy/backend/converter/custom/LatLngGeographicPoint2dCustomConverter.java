/*
 * Copyright 2020-2020 the original author or authors from the JHapy project.
 *
 * This file is part of the JHapy project, see https://www.jhapy.org/ for more information.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jhapy.backend.converter.custom;

import java.util.stream.Collectors;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;
import org.jhapy.dto.utils.LatLng;
import org.jhapy.dto.utils.Pageable;
import org.jhapy.dto.utils.Pageable.Order.Direction;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.neo4j.types.GeographicPoint2d;
import org.springframework.stereotype.Component;

/**
 * @author jHapy Lead Dev.
 * @version 1.0
 * @since 2019-06-05
 */
@Component
public class LatLngGeographicPoint2dCustomConverter extends
    BidirectionalConverter<LatLng, GeographicPoint2d> {

  @Override
  public GeographicPoint2d convertTo(LatLng source,
      Type<GeographicPoint2d> destinationType, MappingContext context) {
    return new GeographicPoint2d(source.getLat(), source.getLng());
  }

  @Override
  public LatLng convertFrom(GeographicPoint2d source,
      Type<LatLng> destinationType, MappingContext context) {
    return new LatLng(source.getLatitude(), source.getLongitude());
  }
}
