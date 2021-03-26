package com.alibaba.fastjson.support.geo;

import com.alibaba.fastjson.annotation.JSONType;
import java.util.ArrayList;
import java.util.List;

@JSONType(orders = {"type", "bbox", "geometries"}, typeName = "GeometryCollection")
public class GeometryCollection extends Geometry {
    private List<Geometry> geometries = new ArrayList();

    public GeometryCollection() {
        super("GeometryCollection");
    }

    public List<Geometry> getGeometries() {
        return this.geometries;
    }
}
