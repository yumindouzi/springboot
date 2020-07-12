package com.hanxin.commons.utils.resource;

/**
 * @Author: hanxin
 * @Date: 2020/7/11 18:01
 * @Version 1.0
 */
public class ResourceService {

  private static ResourceService instance = new ResourceService();

  public static ResourceService getInstance() {
    return instance;
  }

  private ResourceService() {
  }

  private Resource[] resources = new Resource[] { new FileResource() };

  public Resource getDefaultResource() {
    return resources[0];
  }

  public Resource getResource(String agreement) {
    Resource resource = null;
    for (int i = 0; i < resources.length; i++) {
      resource = resources[i];
      if (resource.isAnalysis(agreement)) {
        return resource;
      }
    }

    return null;
  }

}
