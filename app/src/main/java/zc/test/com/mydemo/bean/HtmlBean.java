package zc.test.com.mydemo.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HtmlBean {

    /**
     * htmlz_data : {"img":"","chilFlowData":{"nodes":[],"edges":[]},"svg":"#icon-yemianzu","attrData":{"name":"页面组1","description":"","theme":""},"icon":"iconfont icon-yemianzu","label":"页面组1","type":"project","module_id":"142c91326ec44b6dadc66e23d645fb11","children":[{"img":"","pertainTo":"wp","svg":"#icon-yemian","attrData":{"public":"No","name":"页面1","description":"","title":""},"icon":"iconfont icon-yemian","remark":"对应mainflow -> name","label":"页面1","baseTree":[{"explain":"字段允许用户输入数据。","svg":"#icon-wenbenkuang","attrData":{"border":"","padding":"","margin":"","Variable":{"pid":"af214a782b4618027ef210679a79bc8acd57","type":"Variable","value":"页面1.变量1","key":"8805c991a38940af441eb79f33d98e6875d7"},"font-weight":"","text-decoration":"","style_properties_applied":"","font-size":"","font-style":"","InputType":"Text","name":"输入框1","width":"","Prompt":{"value":""},"height":""},"icon":"el-icon-document","label":"输入框1","nodeType":"Container","children":[],"name":"Input","layoutType":"Input","id":"d30a009b87dffb39f8ff4cc41c0443699b03","text":"输入框","notAllow":true,"key":"d30a009b87dffb39f8ff4cc41c0443699b03"}],"type":"webpage","splashScreen":"#icon-zhuyemian","parentId":"13f5253b4c6f1cf5bb754a2137a119698d78","module_id":"142c91326ec44b6dadc66e23d645fb11","children":[{"img":"","pertainTo":"wp","svg":"#icon-bianliang","attrData":{"defaultValue":"","dataType":"varchar","name":"变量1","description":""},"icon":"iconfont icon-bianliang","label":"变量1","type":"Variable","parentId":"af214a782b4618027ef210679a79bc8acd57","module_id":"142c91326ec44b6dadc66e23d645fb11","children":[],"name":"Variable","id":"8805c991a38940af441eb79f33d98e6875d7","text":"变量"}],"name":"webpage","id":"af214a782b4618027ef210679a79bc8acd57","text":"页面"}],"nodeMenuType":"project","name":"project","layoutType":"project","id":"13f5253b4c6f1cf5bb754a2137a119698d78","text":"页面组","key":"13f5253b4c6f1cf5bb754a2137a119698d78"}
     */

    private HtmlzDataBean htmlz_data;

    public HtmlzDataBean getHtmlz_data() {
        return htmlz_data;
    }

    public void setHtmlz_data(HtmlzDataBean htmlz_data) {
        this.htmlz_data = htmlz_data;
    }

    public static class HtmlzDataBean {
        /**
         * img :
         * chilFlowData : {"nodes":[],"edges":[]}
         * svg : #icon-yemianzu
         * attrData : {"name":"页面组1","description":"","theme":""}
         * icon : iconfont icon-yemianzu
         * label : 页面组1
         * type : project
         * module_id : 142c91326ec44b6dadc66e23d645fb11
         * children : [{"img":"","pertainTo":"wp","svg":"#icon-yemian","attrData":{"public":"No","name":"页面1","description":"","title":""},"icon":"iconfont icon-yemian","remark":"对应mainflow -> name","label":"页面1","baseTree":[{"explain":"字段允许用户输入数据。","svg":"#icon-wenbenkuang","attrData":{"border":"","padding":"","margin":"","Variable":{"pid":"af214a782b4618027ef210679a79bc8acd57","type":"Variable","value":"页面1.变量1","key":"8805c991a38940af441eb79f33d98e6875d7"},"font-weight":"","text-decoration":"","style_properties_applied":"","font-size":"","font-style":"","InputType":"Text","name":"输入框1","width":"","Prompt":{"value":""},"height":""},"icon":"el-icon-document","label":"输入框1","nodeType":"Container","children":[],"name":"Input","layoutType":"Input","id":"d30a009b87dffb39f8ff4cc41c0443699b03","text":"输入框","notAllow":true,"key":"d30a009b87dffb39f8ff4cc41c0443699b03"}],"type":"webpage","splashScreen":"#icon-zhuyemian","parentId":"13f5253b4c6f1cf5bb754a2137a119698d78","module_id":"142c91326ec44b6dadc66e23d645fb11","children":[{"img":"","pertainTo":"wp","svg":"#icon-bianliang","attrData":{"defaultValue":"","dataType":"varchar","name":"变量1","description":""},"icon":"iconfont icon-bianliang","label":"变量1","type":"Variable","parentId":"af214a782b4618027ef210679a79bc8acd57","module_id":"142c91326ec44b6dadc66e23d645fb11","children":[],"name":"Variable","id":"8805c991a38940af441eb79f33d98e6875d7","text":"变量"}],"name":"webpage","id":"af214a782b4618027ef210679a79bc8acd57","text":"页面"}]
         * nodeMenuType : project
         * name : project
         * layoutType : project
         * id : 13f5253b4c6f1cf5bb754a2137a119698d78
         * text : 页面组
         * key : 13f5253b4c6f1cf5bb754a2137a119698d78
         */

        private String img;
        private ChilFlowDataBean chilFlowData;
        private String svg;
        private AttrDataBean attrData;
        private String icon;
        private String label;
        private String type;
        private String module_id;
        private String nodeMenuType;
        private String name;
        private String layoutType;
        private String id;
        private String text;
        private String key;
        private List<ChildrenBeanX> children;

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public ChilFlowDataBean getChilFlowData() {
            return chilFlowData;
        }

        public void setChilFlowData(ChilFlowDataBean chilFlowData) {
            this.chilFlowData = chilFlowData;
        }

        public String getSvg() {
            return svg;
        }

        public void setSvg(String svg) {
            this.svg = svg;
        }

        public AttrDataBean getAttrData() {
            return attrData;
        }

        public void setAttrData(AttrDataBean attrData) {
            this.attrData = attrData;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getModule_id() {
            return module_id;
        }

        public void setModule_id(String module_id) {
            this.module_id = module_id;
        }

        public String getNodeMenuType() {
            return nodeMenuType;
        }

        public void setNodeMenuType(String nodeMenuType) {
            this.nodeMenuType = nodeMenuType;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLayoutType() {
            return layoutType;
        }

        public void setLayoutType(String layoutType) {
            this.layoutType = layoutType;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public List<ChildrenBeanX> getChildren() {
            return children;
        }

        public void setChildren(List<ChildrenBeanX> children) {
            this.children = children;
        }

        public static class ChilFlowDataBean {
            private List<?> nodes;
            private List<?> edges;

            public List<?> getNodes() {
                return nodes;
            }

            public void setNodes(List<?> nodes) {
                this.nodes = nodes;
            }

            public List<?> getEdges() {
                return edges;
            }

            public void setEdges(List<?> edges) {
                this.edges = edges;
            }
        }

        public static class AttrDataBean {
            /**
             * name : 页面组1
             * description :
             * theme :
             */

            private String name;
            private String description;
            private String theme;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getTheme() {
                return theme;
            }

            public void setTheme(String theme) {
                this.theme = theme;
            }
        }

        public static class ChildrenBeanX {
            /**
             * img :
             * pertainTo : wp
             * svg : #icon-yemian
             * attrData : {"public":"No","name":"页面1","description":"","title":""}
             * icon : iconfont icon-yemian
             * remark : 对应mainflow -> name
             * label : 页面1
             * baseTree : [{"explain":"字段允许用户输入数据。","svg":"#icon-wenbenkuang","attrData":{"border":"","padding":"","margin":"","Variable":{"pid":"af214a782b4618027ef210679a79bc8acd57","type":"Variable","value":"页面1.变量1","key":"8805c991a38940af441eb79f33d98e6875d7"},"font-weight":"","text-decoration":"","style_properties_applied":"","font-size":"","font-style":"","InputType":"Text","name":"输入框1","width":"","Prompt":{"value":""},"height":""},"icon":"el-icon-document","label":"输入框1","nodeType":"Container","children":[],"name":"Input","layoutType":"Input","id":"d30a009b87dffb39f8ff4cc41c0443699b03","text":"输入框","notAllow":true,"key":"d30a009b87dffb39f8ff4cc41c0443699b03"}]
             * type : webpage
             * splashScreen : #icon-zhuyemian
             * parentId : 13f5253b4c6f1cf5bb754a2137a119698d78
             * module_id : 142c91326ec44b6dadc66e23d645fb11
             * children : [{"img":"","pertainTo":"wp","svg":"#icon-bianliang","attrData":{"defaultValue":"","dataType":"varchar","name":"变量1","description":""},"icon":"iconfont icon-bianliang","label":"变量1","type":"Variable","parentId":"af214a782b4618027ef210679a79bc8acd57","module_id":"142c91326ec44b6dadc66e23d645fb11","children":[],"name":"Variable","id":"8805c991a38940af441eb79f33d98e6875d7","text":"变量"}]
             * name : webpage
             * id : af214a782b4618027ef210679a79bc8acd57
             * text : 页面
             */

            private String img;
            private String pertainTo;
            private String svg;
            private AttrDataBeanX attrData;
            private String icon;
            private String remark;
            private String label;
            private String type;
            private String splashScreen;
            private String parentId;
            private String module_id;
            private String name;
            private String id;
            private String text;
            private List<BaseTreeBean> baseTree;
            private List<ChildrenBean> children;

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getPertainTo() {
                return pertainTo;
            }

            public void setPertainTo(String pertainTo) {
                this.pertainTo = pertainTo;
            }

            public String getSvg() {
                return svg;
            }

            public void setSvg(String svg) {
                this.svg = svg;
            }

            public AttrDataBeanX getAttrData() {
                return attrData;
            }

            public void setAttrData(AttrDataBeanX attrData) {
                this.attrData = attrData;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getSplashScreen() {
                return splashScreen;
            }

            public void setSplashScreen(String splashScreen) {
                this.splashScreen = splashScreen;
            }

            public String getParentId() {
                return parentId;
            }

            public void setParentId(String parentId) {
                this.parentId = parentId;
            }

            public String getModule_id() {
                return module_id;
            }

            public void setModule_id(String module_id) {
                this.module_id = module_id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public List<BaseTreeBean> getBaseTree() {
                return baseTree;
            }

            public void setBaseTree(List<BaseTreeBean> baseTree) {
                this.baseTree = baseTree;
            }

            public List<ChildrenBean> getChildren() {
                return children;
            }

            public void setChildren(List<ChildrenBean> children) {
                this.children = children;
            }

            public static class AttrDataBeanX {
                /**
                 * public : No
                 * name : 页面1
                 * description :
                 * title :
                 */

                @SerializedName("public")
                private String publicX;
                private String name;
                private String description;
                private String title;

                public String getPublicX() {
                    return publicX;
                }

                public void setPublicX(String publicX) {
                    this.publicX = publicX;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }
            }

            public static class BaseTreeBean {
                /**
                 * explain : 字段允许用户输入数据。
                 * svg : #icon-wenbenkuang
                 * attrData : {"border":"","padding":"","margin":"","Variable":{"pid":"af214a782b4618027ef210679a79bc8acd57","type":"Variable","value":"页面1.变量1","key":"8805c991a38940af441eb79f33d98e6875d7"},"font-weight":"","text-decoration":"","style_properties_applied":"","font-size":"","font-style":"","InputType":"Text","name":"输入框1","width":"","Prompt":{"value":""},"height":""}
                 * icon : el-icon-document
                 * label : 输入框1
                 * nodeType : Container
                 * children : []
                 * name : Input
                 * layoutType : Input
                 * id : d30a009b87dffb39f8ff4cc41c0443699b03
                 * text : 输入框
                 * notAllow : true
                 * key : d30a009b87dffb39f8ff4cc41c0443699b03
                 */

                private String explain;
                private String svg;
                private AttrDataBeanXX attrData;
                private String icon;
                private String label;
                private String nodeType;
                private String name;
                private String layoutType;
                private String id;
                private String text;
                private boolean notAllow;
                private String key;
                private List<?> children;

                public String getExplain() {
                    return explain;
                }

                public void setExplain(String explain) {
                    this.explain = explain;
                }

                public String getSvg() {
                    return svg;
                }

                public void setSvg(String svg) {
                    this.svg = svg;
                }

                public AttrDataBeanXX getAttrData() {
                    return attrData;
                }

                public void setAttrData(AttrDataBeanXX attrData) {
                    this.attrData = attrData;
                }

                public String getIcon() {
                    return icon;
                }

                public void setIcon(String icon) {
                    this.icon = icon;
                }

                public String getLabel() {
                    return label;
                }

                public void setLabel(String label) {
                    this.label = label;
                }

                public String getNodeType() {
                    return nodeType;
                }

                public void setNodeType(String nodeType) {
                    this.nodeType = nodeType;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getLayoutType() {
                    return layoutType;
                }

                public void setLayoutType(String layoutType) {
                    this.layoutType = layoutType;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public boolean isNotAllow() {
                    return notAllow;
                }

                public void setNotAllow(boolean notAllow) {
                    this.notAllow = notAllow;
                }

                public String getKey() {
                    return key;
                }

                public void setKey(String key) {
                    this.key = key;
                }

                public List<?> getChildren() {
                    return children;
                }

                public void setChildren(List<?> children) {
                    this.children = children;
                }

                public static class AttrDataBeanXX {
                    /**
                     * border :
                     * padding :
                     * margin :
                     * Variable : {"pid":"af214a782b4618027ef210679a79bc8acd57","type":"Variable","value":"页面1.变量1","key":"8805c991a38940af441eb79f33d98e6875d7"}
                     * font-weight :
                     * text-decoration :
                     * style_properties_applied :
                     * font-size :
                     * font-style :
                     * InputType : Text
                     * name : 输入框1
                     * width :
                     * Prompt : {"value":""}
                     * height :
                     */

                    private String border;
                    private String padding;
                    private String margin;
                    private VariableBean Variable;
                    @SerializedName("font-weight")
                    private String fontweight;
                    @SerializedName("text-decoration")
                    private String textdecoration;
                    private String style_properties_applied;
                    @SerializedName("font-size")
                    private String fontsize;
                    @SerializedName("font-style")
                    private String fontstyle;
                    private String InputType;
                    private String name;
                    private String width;
                    private PromptBean Prompt;
                    private String height;

                    public String getBorder() {
                        return border;
                    }

                    public void setBorder(String border) {
                        this.border = border;
                    }

                    public String getPadding() {
                        return padding;
                    }

                    public void setPadding(String padding) {
                        this.padding = padding;
                    }

                    public String getMargin() {
                        return margin;
                    }

                    public void setMargin(String margin) {
                        this.margin = margin;
                    }

                    public VariableBean getVariable() {
                        return Variable;
                    }

                    public void setVariable(VariableBean Variable) {
                        this.Variable = Variable;
                    }

                    public String getFontweight() {
                        return fontweight;
                    }

                    public void setFontweight(String fontweight) {
                        this.fontweight = fontweight;
                    }

                    public String getTextdecoration() {
                        return textdecoration;
                    }

                    public void setTextdecoration(String textdecoration) {
                        this.textdecoration = textdecoration;
                    }

                    public String getStyle_properties_applied() {
                        return style_properties_applied;
                    }

                    public void setStyle_properties_applied(String style_properties_applied) {
                        this.style_properties_applied = style_properties_applied;
                    }

                    public String getFontsize() {
                        return fontsize;
                    }

                    public void setFontsize(String fontsize) {
                        this.fontsize = fontsize;
                    }

                    public String getFontstyle() {
                        return fontstyle;
                    }

                    public void setFontstyle(String fontstyle) {
                        this.fontstyle = fontstyle;
                    }

                    public String getInputType() {
                        return InputType;
                    }

                    public void setInputType(String InputType) {
                        this.InputType = InputType;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getWidth() {
                        return width;
                    }

                    public void setWidth(String width) {
                        this.width = width;
                    }

                    public PromptBean getPrompt() {
                        return Prompt;
                    }

                    public void setPrompt(PromptBean Prompt) {
                        this.Prompt = Prompt;
                    }

                    public String getHeight() {
                        return height;
                    }

                    public void setHeight(String height) {
                        this.height = height;
                    }

                    public static class VariableBean {
                        /**
                         * pid : af214a782b4618027ef210679a79bc8acd57
                         * type : Variable
                         * value : 页面1.变量1
                         * key : 8805c991a38940af441eb79f33d98e6875d7
                         */

                        private String pid;
                        private String type;
                        private String value;
                        private String key;

                        public String getPid() {
                            return pid;
                        }

                        public void setPid(String pid) {
                            this.pid = pid;
                        }

                        public String getType() {
                            return type;
                        }

                        public void setType(String type) {
                            this.type = type;
                        }

                        public String getValue() {
                            return value;
                        }

                        public void setValue(String value) {
                            this.value = value;
                        }

                        public String getKey() {
                            return key;
                        }

                        public void setKey(String key) {
                            this.key = key;
                        }
                    }

                    public static class PromptBean {
                        /**
                         * value :
                         */

                        private String value;

                        public String getValue() {
                            return value;
                        }

                        public void setValue(String value) {
                            this.value = value;
                        }
                    }
                }
            }

            public static class ChildrenBean {
                /**
                 * img :
                 * pertainTo : wp
                 * svg : #icon-bianliang
                 * attrData : {"defaultValue":"","dataType":"varchar","name":"变量1","description":""}
                 * icon : iconfont icon-bianliang
                 * label : 变量1
                 * type : Variable
                 * parentId : af214a782b4618027ef210679a79bc8acd57
                 * module_id : 142c91326ec44b6dadc66e23d645fb11
                 * children : []
                 * name : Variable
                 * id : 8805c991a38940af441eb79f33d98e6875d7
                 * text : 变量
                 */

                private String img;
                private String pertainTo;
                private String svg;
                private AttrDataBeanXXX attrData;
                private String icon;
                private String label;
                private String type;
                private String parentId;
                private String module_id;
                private String name;
                private String id;
                private String text;
                private List<?> children;

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public String getPertainTo() {
                    return pertainTo;
                }

                public void setPertainTo(String pertainTo) {
                    this.pertainTo = pertainTo;
                }

                public String getSvg() {
                    return svg;
                }

                public void setSvg(String svg) {
                    this.svg = svg;
                }

                public AttrDataBeanXXX getAttrData() {
                    return attrData;
                }

                public void setAttrData(AttrDataBeanXXX attrData) {
                    this.attrData = attrData;
                }

                public String getIcon() {
                    return icon;
                }

                public void setIcon(String icon) {
                    this.icon = icon;
                }

                public String getLabel() {
                    return label;
                }

                public void setLabel(String label) {
                    this.label = label;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getParentId() {
                    return parentId;
                }

                public void setParentId(String parentId) {
                    this.parentId = parentId;
                }

                public String getModule_id() {
                    return module_id;
                }

                public void setModule_id(String module_id) {
                    this.module_id = module_id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public List<?> getChildren() {
                    return children;
                }

                public void setChildren(List<?> children) {
                    this.children = children;
                }

                public static class AttrDataBeanXXX {
                    /**
                     * defaultValue :
                     * dataType : varchar
                     * name : 变量1
                     * description :
                     */

                    private String defaultValue;
                    private String dataType;
                    private String name;
                    private String description;

                    public String getDefaultValue() {
                        return defaultValue;
                    }

                    public void setDefaultValue(String defaultValue) {
                        this.defaultValue = defaultValue;
                    }

                    public String getDataType() {
                        return dataType;
                    }

                    public void setDataType(String dataType) {
                        this.dataType = dataType;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getDescription() {
                        return description;
                    }

                    public void setDescription(String description) {
                        this.description = description;
                    }
                }
            }
        }
    }
}
