/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.viettd.elasticsearch.plugin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.elasticsearch.common.inject.Module;
import org.elasticsearch.index.analysis.AnalysisModule;
import org.elasticsearch.plugins.Plugin;
import com.github.viettd.elasticsearch.analysis.NormalizationBinderProcessor;
import com.github.viettd.elasticsearch.analysis.NormalizationIndicesAnalysisModule;
import com.github.viettd.elasticsearch.analysis.NormalizedKeyWordBinderProcessor;
import com.github.viettd.elasticsearch.analysis.NormalizedKeyWordIndicesAnalysisModule;

/**
 *
 * @author viettd
 */
public class VietnameseNormalizer extends Plugin {

    @Override
    public String name() {
        return "vietnamese-normalizer";
    }

    @Override
    public String description() {
        return "Elasticsearch Vietnamese Normalizer Plugin";
    }

    @Override
    public Collection<Module> nodeModules() {
        List<Module> lst = new ArrayList();
        lst.add(new NormalizedKeyWordIndicesAnalysisModule());
        lst.add(new NormalizationIndicesAnalysisModule());
        return lst;

    }

    public void onModule(AnalysisModule module) {
        module.addProcessor(new NormalizedKeyWordBinderProcessor());
        module.addProcessor(new NormalizationBinderProcessor());
    }

}
