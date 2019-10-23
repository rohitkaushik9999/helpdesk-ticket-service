USE [helpdesk]
GO
/****** Object:  Table [dbo].[user]    Script Date: 12-09-2019 12:20:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user](
	[ID] [bigint] IDENTITY(1,1) NOT NULL,
	[username] [varchar](50) NULL,
	[password] [varchar](50) NULL,
	[email] [varchar](50) NULL,
	[role] [varchar](50) NULL,
 CONSTRAINT [PK_user] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
)ON [PRIMARY]
GO
