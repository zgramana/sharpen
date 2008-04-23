/* Copyright (C) 2004 - 2008  db4objects Inc.  http://www.db4o.com

This file is part of the sharpen open source java to c# translator.

sharpen is free software; you can redistribute it and/or modify it under
the terms of version 2 of the GNU General Public License as published
by the Free Software Foundation and as clarified by db4objects' GPL 
interpretation policy, available at
http://www.db4o.com/about/company/legalpolicies/gplinterpretation/
Alternatively you can write to db4objects, Inc., 1900 S Norfolk Street,
Suite 350, San Mateo, CA 94403, USA.

sharpen is distributed in the hope that it will be useful, but WITHOUT ANY
WARRANTY; without even the implied warranty of MERCHANTABILITY or
FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
for more details.

You should have received a copy of the GNU General Public License along
with this program; if not, write to the Free Software Foundation, Inc.,
59 Temple Place - Suite 330, Boston, MA  02111-1307, USA. */

package sharpen.core;

import java.util.*;

public class JavaToCSharpCommandLine {
	
	public static JavaToCSharpCommandLine parse(String[] args) {
		return new JavaToCSharpCommandLineParser(args).commandLine();
	}
	
	public static enum PascalCaseOptions {
		None {
			@Override
			public NamingStrategy getNamingStrategy() {
				return NamingStrategy.DEFAULT;
			}
		},
		Identifiers{
			@Override
			public NamingStrategy getNamingStrategy() {
				return PascalCaseIdentifiersNamingStrategy.DEFAULT;
			}
		},
		NamespaceAndIdentifiers{
			@Override
			public NamingStrategy getNamingStrategy() {
				return PascalCaseNamingStrategy.DEFAULT;
			}
		};

		public abstract NamingStrategy getNamingStrategy();
	}

	public String runtimeTypeName = Configuration.DEFAULT_RUNTIME_TYPE_NAME;
	public boolean nativeTypeSystem;
	public PascalCaseOptions pascalCase = PascalCaseOptions.None;
	public String project;
	final public List<String> classpath = new ArrayList<String>();
	final public List<String> sourceFolders = new ArrayList<String>();
	final public List<Configuration.NameMapping> namespaceMappings = new ArrayList<Configuration.NameMapping>();
	final public List<Configuration.NameMapping> typeMappings = new ArrayList<Configuration.NameMapping>();
	final public Map<String, Configuration.MemberMapping> memberMappings = new HashMap<String, Configuration.MemberMapping>();
	public boolean nativeInterfaces;
	public boolean organizeUsings;
	final public List<String> fullyQualifiedTypes = new ArrayList<String>();
	public String headerFile;
	public String xmldoc;
}